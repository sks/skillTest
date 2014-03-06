package com.sks.skill.basic.server.oio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

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

}
