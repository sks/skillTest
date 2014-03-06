package com.sks.skill.basic.oio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Sabith_ks
 * Inspired by https://www.youtube.com/watch?v=vkjNjZiMt4w
 * 
 * Using the old I/O
 * 
 * Using the telnet localhost 8080 
 * second  terminal does get response now , Better than the SingleThreadServer that we had
 *
 */
public class MultiThreadedServer {


	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		ServerSocket	serverSocket	= new ServerSocket(SocketClient.DEFAULT_PORT);
		while(true){
			//waits for a connnection to arrive,
			//may or not return null
			Socket socket	= serverSocket.accept();
			//Lambda for creating a new thread
			new Thread(() -> Util.processSocketRequest(socket)).start();
		}
	}

	
}