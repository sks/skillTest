package com.sks.skill.searching;

/**
 * @author Sabith_ks
 * finds the pivot in a rotated array
 */
public class RotatedArraySearch<T extends Comparable<T>> {

	public int getPivot(T[] array){
		int high	= array.length-1;
		int low		= 0;
		int middle;
		while(array[low].compareTo(array[high])>0){
			//low is higher than the high. Not good.
			middle	= low + (high-low)/2;
			//If the middle value is higher than the high: then we make middle the new low
			if(array[middle].compareTo(array[high])>0) {
				low = middle + 1;
			} else {
				high= middle;
			}
		}
		return low;
	}
	
	public static void main(String[] args){
		System.out.println(new RotatedArraySearch<Integer>().getPivot(new Integer[]{2,3,4,5,6,7,8,1}));
	}
}
