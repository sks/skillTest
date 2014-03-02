package com.sks.skill.basic;

import java.util.logging.Logger;

public class Common {

	public static final String terminator	 = "0";
	
	private static Logger logger 	= Logger.getLogger("Common");

	/**
	 * 
	 */
	public static void createBreak() {
		String character	= "-";
		for(int i =  0 ; i <5; i++){
			character+= character;
		}
		System.out.println(character);

	}

	/**
	 * @param arr
	 * @return
	 */
	public static boolean checkIfSorted(Integer[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i-1] > arr[i]){
				//The array is not sorted
				logger.warning("Array has ["+arr[i-1] +"("+(i-1)+")] greater than ["+arr[i]+"(" +i+")]");
				return false;
			}
		}
		return true;
	}
}
