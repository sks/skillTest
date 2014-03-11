package com.sks.skill.basic.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

/**
 * @author Sabith_ks
 *
 */
public class ThreadMain {

	private static Random random	= new Random();
	
	private Map<Integer, Long> map	= new HashMap<Integer, Long>();
	
	private static final int MAX_ARRAY_SIZE	= 100;
	
	private static int[] intArray = new int[MAX_ARRAY_SIZE];
	
	static{
		for(int index=0; index<MAX_ARRAY_SIZE; index++){
			intArray[index]= random.nextInt();
		}
		
	}
	
	/**
	 * 
	 */
	ThreadMain(){
		for(int index=0; index<MAX_ARRAY_SIZE; index++){
			map.put(random.nextInt(), random.nextLong());
		}
		map.put(100, 1000L);
	}
	
	Logger	logger	= Logger.getLogger(getClass());
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		new ThreadMain().process();
	}


	/**
	 * 
	 */
	private void process() {
		
		for(int i=0 ; i< 20; i++){
			new Thread(() -> {
				map.put(100, Thread.currentThread().getId());
				logger.info(Thread.currentThread().getId()+ " In thread "+map.get(100));
				return;
			}).start();
		}
		
		System.out.println("Outside "+map.get(100));
		
		for(int i=0 ; i< 20; i++){
			new Thread(() -> {
				logger.info("Output thread "+map.get(100));
				return;
			}).start();
		}
		
		System.out.println("Outside "+map.get(100));
	}
	
}
