package com.sks.skill.sorting;

import com.sks.skill.sorting.cocktail.BubbleSort;

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
		default:
			return null;
		}
	}
}
