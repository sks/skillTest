package com.sks.skill.searching;

/**
 * @author Sabith_ks
 *
 */
public class LinearSearch implements SearchMechanism {

	@Override
	public int search(Integer[] array, int value) {
		for(int index= 0 ; index< array.length; index++){
			if(array[index]==value){
				return index;
			}
		}
		return -1;
	}

}
