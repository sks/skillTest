package com.sks.skill.sorting;

import com.sks.skill.sorting.cocktail.BubbleSort;
import com.sks.skill.sorting.merge.MergeSort;
import com.sks.skill.sorting.quick.QuickSort;
import com.sks.skill.sorting.simple.InsertionSort;

/**
 * @author Sabith_ks
 *
 */
public class SortingFactory {

	/**
	 * @param sortingType
	 * @return
	 */
	public static SortingMechanism getSortingMechanism(SortingType sortingType){
		switch(sortingType){
		case BUBBLE: 
			return new BubbleSort();
		case INSERTION:
			return new InsertionSort();
		case MERGE:
			return new MergeSort();
		case QUICK:
			return new QuickSort();
		default:
			return null;
		}
	}
}
