package com.sks.skill.basic.server.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import com.sks.skill.basic.server.oio.Util;

/**
 * @author Sabith_ks
 * Java is too busy and takes up 100% CPU utilisation (NOT Good)
 * java is too busy checking for any new connections all the time
 * If there are more connections, we end up having 
 * 				Exception in thread "main" java.io.IOException: Too many open files in system
 *
 */
public class NonBlockingSingleThreadedPollingServer {

	
	/**
	 * Convert the map to a set
	 */
	private static Collection<SocketChannel> sockets = Collections.newSetFromMap(
			new HashMap<SocketChannel, Boolean>()
			);

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		//Byte Buffer allocation
		ByteBuffer byteBuffer	= ByteBuffer.allocateDirect(1024);
		ServerSocketChannel	serverSocketChannel	= ServerSocketChannel.open();
		//Bind the server socket to a interface.
		serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));
		serverSocketChannel.configureBlocking(false);
		while(true){
			SocketChannel socketChannel	= serverSocketChannel.accept();
			//non-blocking call -- usually null!!!
			if(socketChannel != null){
				socketChannel.configureBlocking(false);
				sockets.add(socketChannel);
				System.out.println("New Connection from "+socketChannel+" on thread "+Thread.currentThread().getId()+". Total concurrent connection "+sockets.size());
			}
			
			//iterate through the open sockets
			//Using foreach loop so that we can remove the object from the set
			for(Iterator<SocketChannel> iterator = sockets.iterator(); iterator.hasNext(); ){
				SocketChannel sChannel	= iterator.next();
				try{
					int read	= sChannel.read(byteBuffer);
					//Remove the socket channel from set if the connection is closed
					if(read == -1){
						//if the socket is closed, remove it from the set
						iterator.remove();
						System.out.println("Connection  Closed from "+sChannel+" on thread "+Thread.currentThread().getId()+". Total concurrent connection "+sockets.size());;
					}else if(read != 0){
						System.out.println("Some new character from "+sChannel+" on thread "+Thread.currentThread().getId());
						byteBuffer.flip();
						//Transmogify  
						for(int index=0; index< byteBuffer.limit(); index++){
							byteBuffer.put(index, (byte) Util.transmogify(byteBuffer.get(index)));
						}
						sChannel.write(byteBuffer);
						//clear the byte buffer
						byteBuffer.clear();
					}
				} catch (IOException e) {
					//in case of error, remove the socket 
					iterator.remove();
					System.err.println("Error while connecting : "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
}
