package com.sks.skill.basic.oio;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Sabith_ks
 *  we are using the cached Pool
 *
 */
public class SocketClient {


	public static final int MAX_COUNT = 3000;

	/**
	 * Default port 
	 */
	public static final int DEFAULT_PORT = 8080;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException{
		for(int count=0; count<MAX_COUNT; count++){
			new Socket("localhost", DEFAULT_PORT);
			System.out.println(count);

		}
	}
}
