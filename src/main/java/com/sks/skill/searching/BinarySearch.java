package com.sks.skill.searching;

import java.util.Arrays;

/**
 * @author Sabith_ks
 *
 */
public class BinarySearch implements SearchMechanism{

	private Integer[] array;

	@Override
	public int search(Integer[] array, int value) {
		Arrays.sort(array);
		this.array = array;
		return binarySearch(0, array.length, value);
	}

	/**
	 * @param low
	 * @param high
	 * @param value
	 * @return the index in case the value is present, other wise , -1
	 */
	private int binarySearch(int low, int high,int value) {
		int middle	;
		if(low <= high){
			middle = low + (high-low)/2;
			if(array[middle] > value){
				high = middle-1;
			}else if(array[middle]< value){
				low = middle+1;
			}else{
				return middle;
			}
			return binarySearch(low, high, value);
		}
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println(new BinarySearch().search(new Integer[]{1, 2, 3 , 4 , 5 , 6, 7}, 3));
	}

}
