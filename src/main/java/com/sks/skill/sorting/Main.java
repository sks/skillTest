package com.sks.skill.sorting;

import java.util.logging.Logger;

import org.apache.commons.lang.time.StopWatch;

import com.sks.skill.basic.Common;

public class Main {

	private static Logger logger 	= Logger.getLogger("MAIN");

	private static final int totalArraySize	= 10000;

	private static StopWatch stopWatch	= new StopWatch();

	/**
	 * @return
	 */
	public static Integer[] getRandomArray(int totalSize){
		Integer[] integers	= new Integer[totalSize];
		for(int i=0; i<totalSize; i++){
			integers[i] = (int) Math.floor(Math.random()*(totalSize*1000));
		}
		return integers;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args){
		//Arrays.sort(getRandomArray());
		for(SortingType sortingType : SortingType.values()){
			//Now lets increase the load as we go forward
			//Lets get the sorting mecahnism from the factory
			SortingMechanism sortingMechanism = SortingFactory.getSortingMechanism(sortingType);
			Common.createBreak();
			System.out.println("Sorting algorithm -> "+sortingType+" sort");
			for(int arraySize=10; arraySize<= totalArraySize; arraySize= arraySize*10){
				//Trying the sort using arraySize 
				try{
					//Stop Watch start
					stopWatch.start();
					Integer[] array = getRandomArray(arraySize);
					array  = sortingMechanism.sort(array);
					//Stop watch end
					stopWatch.stop();
					//Validate if the array is sorted
					if(! Common.checkIfSorted(array)){
						throw new Exception("The sorting by "+sortingType+" did not give the expected sort");
					}
					System.out.println("Time : "+stopWatch.getTime()+"\tTotal Size "+arraySize);
				}catch(Exception e){
					logger.warning("Error while doing the sort using "+sortingType);
					e.printStackTrace();
				}finally{
					stopWatch.reset();
				}
			}
		}
		Common.createBreak();
		Common.createBreak();
	}

}
