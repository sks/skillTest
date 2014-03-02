package com.sks.skill.sorting.merge;

import com.sks.skill.sorting.SortingMechanism;

/**
 * @author Sabith_ks
 * http://en.wikipedia.org/wiki/Merge_sort
 * http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
 * Best : O(n log n) comparison-based sorting algorithm
 */
public class MergeSort implements SortingMechanism {

	private Integer[] array;

	private Integer[] helperArray;

	@Override
	public Integer[] sort(Integer[] array) throws Exception {
		//first divide them to equal halves and get a sorted lists
		this.array	= array;
		helperArray = new Integer[array.length];
		mergeSort(0, array.length-1);
		return array;
	}

	private void mergeSort(int low, int high) {
		if(low<high){
			//divide the array to equal halves
			int middle	= low+(high - low)/2;
			mergeSort(low, middle);
			mergeSort(middle+1, high);
			//Once that we have a sorted thing, combine them together
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helperArray[i] = array[i];
		}
		//here comes the actual logic
		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helperArray[i] <= helperArray[j]) {
				array[k] = helperArray[i];
				i++;
			} else {
				array[k] = helperArray[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			array[k] = helperArray[i];
			k++;
			i++;
		}
	}
}