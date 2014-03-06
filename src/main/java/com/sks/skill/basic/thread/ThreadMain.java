package com.sks.skill.basic.thread;

import java.util.Random;

import org.apache.commons.lang.time.StopWatch;

/**
 * @author Sabith_ks
 *
 */
public class ThreadMain {

	private static Random random	= new Random();
	
	private static final int MAX_ARRAY_SIZE	= 100000000;
	
	private static int[] intArray = new int[MAX_ARRAY_SIZE];
	
	static{
		for(int index=0; index<MAX_ARRAY_SIZE; index++){
			intArray[index]= random.nextInt();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args){
		StopWatch stopWatch	= new StopWatch();
		//Start the stop Watch
		stopWatch.start();
		//Calculate the sum
		int sum = new ThreadMain().addArray(intArray, 0, MAX_ARRAY_SIZE);
		//Stop the watch 
		stopWatch.stop();
		
		//Note the time
		System.out.println("Calculated the sum in "+stopWatch.getTime());
	}
	
	/**
	 * @param intArray
	 * @param i
	 * @param j
	 * @return 
	 */
	private int addArray(int[] intArray, int from, int to) {
		int sum	= 0;
		for(;from<to; from++){
			sum +=  intArray[from];
		}
		return  sum;
	}
}
