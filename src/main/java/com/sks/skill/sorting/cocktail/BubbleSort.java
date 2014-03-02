package com.sks.skill.sorting.cocktail;

import com.sks.skill.sorting.SortingMechanism;

/**
 * @author Sabith_ks
 * Disadvantage : in-efficient
 * Don't use
 */
public class BubbleSort implements SortingMechanism{

	/**
	 * @param arrays
	 * @throws InterruptedException 
	 */
	public Integer[]  sort(Integer[] arrays) throws InterruptedException{
		for(int current = 0 ; current <arrays.length;  current++){
			//check with the elements that are coming afterwards
			for(int nextElement = current;  nextElement<arrays.length;  nextElement++){
				if(arrays[nextElement]< arrays[current]){
					//if the next is less than the current , swap
					//x = x+y - (y=x) , at the end we get that x =y & y=x 
					arrays[current] = (arrays[nextElement]+arrays[current]) - (arrays[nextElement]=arrays[current]);
				}
			}
		}
		return arrays;
	}
}