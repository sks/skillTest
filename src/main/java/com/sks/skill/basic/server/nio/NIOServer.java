package com.sks.skill.basic.server.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sks.skill.basic.server.oio.Util;

/**
 * @author Sabith_ks
 *
 */
public class NIOServer {

	public static void main(String[] args) throws IOException {
		//You open a server socket channel
		ServerSocketChannel	serverSocketChannel	= ServerSocketChannel.open();
		//Bind the server socket to a interface.
		serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));
		ExecutorService pool 	= Executors.newFixedThreadPool(1000);
		while(true){
			SocketChannel socket	= serverSocketChannel.accept();
			//lambda notation for a new thread
			pool.submit(() -> Util.processSocketChannelRequest(socket));
		}
	}
}
