package com.sks.skill.basic.server.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sks.skill.basic.server.oio.Util;

/**
 * @author Sabith_ks
 *
 */
public class NonBlockingMultiThreadedSelectorServer {

	/**
	 *  Using concurrent hash map as we have multiple threads
	 */
	private static Map<SocketChannel, Queue<ByteBuffer>> pendingSocketWrite = new ConcurrentHashMap<SocketChannel, Queue<ByteBuffer>>();

	/**
	 * 
	 */
	private static  Queue<SocketChannel> channelsToWrite	= new ConcurrentLinkedQueue<SocketChannel>();
	
	
	/**
	 *  the pool of threads
	 */
	private static ExecutorService	pool	= Executors.newFixedThreadPool(100);
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		//Byte Buffer allocation
		ServerSocketChannel	serverSocketChannel	= ServerSocketChannel.open();
		//Bind the server socket to a interface.
		serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));
		serverSocketChannel.configureBlocking(false);
		//Create a selector
		Selector selector	= Selector.open();
		//Register the selector onto the server socket channel;
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while(true){
			//Once there is a connect, this would react.
			selector.select();
			//check if this socket is supposed to be written.
			SocketChannel writePendingSocketChannel;
			while((writePendingSocketChannel = channelsToWrite.poll()) !=null) {
				//write the changes outside the thread
				writePendingSocketChannel.register(selector, SelectionKey.OP_WRITE);
			}
			//Key select
			for(Iterator<SelectionKey> iterator = selector.selectedKeys().iterator(); iterator.hasNext();){
				SelectionKey key	= iterator.next();
				iterator.remove();
				//check if the socket is closed or not
				if(key.isValid()){
					if(key.isAcceptable()) {
						//Someone connected to our server socket channel
						accept(key);
					}else  if(key.isReadable()) { 
						read(key);
					}else if(key.isWritable()) {
						write(key);
					}
				}
			}
		}
	}

	/**
	 * @param key
	 * @throws IOException 
	 */
	private static void write(SelectionKey key) throws IOException {
		SocketChannel sChannel	= (SocketChannel) key.channel();
		Queue<ByteBuffer> byteBufferQueue	= pendingSocketWrite.get(sChannel);
		//Read the data from the queue
		ByteBuffer byteBuffer;
		while((byteBuffer = byteBufferQueue.peek()) != null){
			//We are using peek and not poll, bcos, 
			//We are sure the data stays even if there is a data loss in first write
			
			sChannel.write(byteBuffer);
			if(! byteBuffer.hasRemaining()){
				//we wrote the everything.
				byteBufferQueue.poll();
			}else{
				//there is something remaining, so that we have reading enabled back
				return;
			}
		}
		//ONce the queue is empty, change the channel back to read
		sChannel.register(key.selector(), SelectionKey.OP_READ);
	}

	/**
	 * @param key
	 */
	private static void read(SelectionKey key) {
		SocketChannel sChannel	= (SocketChannel) key.channel();
		try{
			ByteBuffer byteBuffer	= ByteBuffer.allocate(1024);
			int read	= sChannel.read(byteBuffer);
			//Remove the socket channel from set if the connection is closed
			if(read == -1){
				//if the socket is closed, remove it from the set
				pendingSocketWrite.remove(sChannel);
				//System.out.println("Connection  Closed from "+sChannel+" on thread "+Thread.currentThread().getId()+". Total concurrent connection "+pendingSocketWrite.size());;
				return;
			}
			//Transmogify   will be done by a different thread
			pool.submit(() -> {
				byteBuffer.flip();
				//
				for(int index=0; index< byteBuffer.limit(); index++){
					byteBuffer.put(index, (byte) Util.transmogify(byteBuffer.get(index)));
				}
				//dont write it yet, bcos we are just reading
				//So we add this to the queue 
				pendingSocketWrite.get(sChannel).add(byteBuffer);
				//Now we need  make the socket react once the socket is ready to write.,
				//but not on multi-threaded system as it can cause issues
				// -- sChannel.register(key.selector(), SelectionKey.OP_WRITE);
				key.selector().wakeup(); //wake up  the  selector thread
				channelsToWrite.add(sChannel);
				return null; //mandatory 
			});
		} catch (IOException e) {
			//in case of error, remove the socket 
			System.err.println("Error while connecting : "+e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * @param key
	 * @throws IOException 
	 */
	private static void accept(SelectionKey key) throws IOException {
		ServerSocketChannel serverSocketChannel	= (ServerSocketChannel) key.channel();
		//Get the socket channel out of the server socket channel
		SocketChannel	socketChannel	= serverSocketChannel.accept(); //non-blocking , never null
		socketChannel.configureBlocking(false);
		//We are saying that we are gonna make the read when someone puts somethign in socket.
		socketChannel.register(key.selector(), SelectionKey.OP_READ);
		pendingSocketWrite.put(socketChannel, new ConcurrentLinkedQueue<ByteBuffer>());
	}
}
