package com.sks.skill.sorting.quick;

import com.sks.skill.sorting.SortingMechanism;

/**
 * @author Sabith_ks
 *
 * http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
 * Step : 
 *  1) Choose a pivot
 *  2) partition the array
 *  3) selectors at first and last
 *  4) Divide the partition to 2 sets (one less than pivot and the other greater than pivot)
 *  5) Sort both the sets recursively
 *  
 */
public class QuickSort implements SortingMechanism {

	private Integer[] array;

	@Override
	public Integer[] sort(Integer[] array) throws Exception {
		this.array	= array;
		quickSort(0, array.length-1);
		return this.array;
	}

	/**
	 * @param low
	 * @param high
	 */
	private void quickSort(int low, int high) {
		//Choose a pivot point : somewhere in the middle would be great but not mandatory
		int pivot = array[low + (high-low)/2];
		int lowInt	= low;
		int highInt	= high;
		//time to check the elements based on the pivot
		while(lowInt <= highInt){
			//as long as the low is less than high, lets continue;
			while(array[lowInt]< pivot){
				//this means that the left side is already less than pivot , so lets not change the place
				lowInt++;
			}
			while(array[highInt]> pivot){
				//this means that the right side is greater than the pivot, lets not move that either
				highInt--;
			}
			//If we are here, then that means that the left side has a higher value than pivot 
			//and the right side has a lower value than pivot
			//Swap the left and right if lowInt<highInt
			if(lowInt <= highInt){
				//x = x+y - (y=x) , at the end we get that x =y & y=x 
				array[lowInt] = (array[highInt]+array[lowInt]) - (array[highInt]=array[lowInt]);
				lowInt++;
				highInt--;
			}
		}
		if (low < highInt)
			quickSort(low, highInt);
		if (lowInt < high)
			quickSort(lowInt, high);

	}
}