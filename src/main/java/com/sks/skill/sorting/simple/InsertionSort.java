package com.sks.skill.sorting.simple;

import com.sks.skill.sorting.SortingMechanism;

/**
 * @author Sabith_ks
 *  O(n2) logic
 */
public class InsertionSort implements SortingMechanism {


	public Integer[] sort(Integer[] arrays) throws Exception{
		int i, j, newValue;
		for(i=1; i < arrays.length ; i++){ //Start with 2nd element index=1
			//Now check with 2nd
			newValue	= arrays[i];
			j = i;
			//Check for the previous elements
			while (j > 0 && arrays[j - 1] > newValue) {
				arrays[j] = arrays[j - 1];
				j--;
			}

		}
		return arrays;
	}

}
