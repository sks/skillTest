package com.sks.skill.searching;

import java.util.Random;

import org.apache.commons.lang.time.StopWatch;

import com.sks.skill.basic.Common;

public class SearchAlgorithmMain {
		
	//Maximum array size load
	private static final int totalArraySize	= 1000000000;

	//Stop watch to keep track of time
	private static StopWatch stopWatch	= new StopWatch();

	//Generator for a something random numbers to sort
	private static Random generator = new Random();

	/**
	 * @return
	 */
	public static Integer[] getRandomArray(int totalSize){
		Integer[] integers	= new Integer[totalSize];
		for(int i=0; i<totalSize; i++){
			integers[i] = generator.nextInt(totalSize);
		}
		return integers;
	}

	public static void main(String[] args){
		//for all the linear search
		for(SearchType searchType : SearchType.values()){
			System.out.println("Search type --> "+searchType);
			Common.createBreak();
			SearchMechanism searchMecahnism	= SearchTypeFactory.getInstance(searchType);
			for(int arraySize = 10; arraySize<totalArraySize; arraySize=arraySize*100){
				Integer[] array	= getRandomArray(arraySize);
				//What if the search item was in n-th index
				for(int cases : new Integer[]{0,1, arraySize/2, arraySize-1}){
					stopWatch.start();
					searchMecahnism.search(array, array[cases]);
					stopWatch.stop();
					System.out.println(cases+" Case : Size : "+arraySize+"\t time : "+stopWatch.getTime());
					stopWatch.reset();
				}
				Common.createBreak();
				
			}
			Common.createBreak();
		}
	}
}
