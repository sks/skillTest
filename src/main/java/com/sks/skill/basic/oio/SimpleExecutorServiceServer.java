package com.sks.skill.basic.oio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorServiceServer {

	public static void main(String[] args) throws IOException {
		ServerSocket	serverSocket	= new ServerSocket(SocketClient.DEFAULT_PORT);
//		ExecutorService pool	= new ThreadPoolExecutor(
//				0, 
//				1000, 
//				60L, 
//				TimeUnit.SECONDS, 
//				new SynchronousQueue<Runnable>(), 
//				new ThreadPoolExecutor.CallerRunsPolicy()); //new ThreadPoolExecutor.DiscardPolicy());
		
		//This appears to work.
		ExecutorService pool 	= Executors.newFixedThreadPool(1000);
		while(true){
			Socket socket	= serverSocket.accept();
			//lambda notation for a new thread
			pool.submit(() -> Util.processSocketRequest(socket));
		}
	}

}
