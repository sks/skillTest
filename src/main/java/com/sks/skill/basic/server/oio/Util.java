package com.sks.skill.basic.server.oio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Util {

	/**
	 * @param data
	 * @return the transpose of the data
	 */
	public static int transmogify(int data) {
		if(Character.isLetter(data)){
			//transpose the alphabets a->A, A->a
			return data ^ ' ';
		}
		return data;
	}
	
	/**
	 * @param socket
	 */
	public static void processSocketRequest(Socket socket) {
		System.out.println("Connection from "+socket+" on thread "+Thread.currentThread().getId());
		//http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		
		try(
				InputStream	in	= socket.getInputStream();
				OutputStream output	= socket.getOutputStream();
				){
			int data;
			while((data = in.read())!=-1){
				data	= Util.transmogify(data);
				output.write(data);
			}
		} catch (IOException e) {
			System.err.println("Error while connecting : "+e.getMessage());
			e.printStackTrace();
		}		
	}

	/**
	 * @param socketChannel
	 */
	public static void processSocketChannelRequest(SocketChannel socketChannel) {
		System.out.println("Connection from "+socketChannel+" on thread "+Thread.currentThread().getId());
		//there are no input stream or output stream in here
		try{
			ByteBuffer byteBuffer	= ByteBuffer.allocateDirect(1024);
			//Read from socket channel , if this is -1, means the socket channel is closed
			while(socketChannel.read(byteBuffer)!=-1){
				// Byte buffer is a special buffer
				// byte array with additional information
				// position in  the buffer
				// Length ( limit ) and capacity of the buffer
				
				//To Read :   
				// byteBuffer.limit(byteBuffer.position()); // Set the  limit to position
				// byteBuffer.position(0); // reset the position once we have the position reset to 0;
				//one line code would be 
 				// byteBuffer.limit(byteBuffer.position()).position(0);
				//one liner
				byteBuffer.flip();
				//now loop through the byte and write the buffer
				for(int index=0; index< byteBuffer.limit(); index++){
					byteBuffer.put(index, (byte) transmogify(byteBuffer.get(index)));
				}
				//Write to the socket Channel
				socketChannel.write(byteBuffer);
				//clear the byte buffer
				byteBuffer.clear();
			}
			socketChannel.read(byteBuffer);
			
		} catch (IOException e) {
			System.err.println("Error while connecting : "+e.getMessage());
			e.printStackTrace();
		}
		return ;
	}

}
