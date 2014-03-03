package com.sks.skill.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPermutaion {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		List<Integer[]> answers	= new NumberPermutaion().getPermutation(new Integer[]{1,2, 3, 4}, 0);
		for(Integer[] answer : answers){
			System.out.println(Arrays.asList(answer));
		};
		System.out.println("Total "+answers.size());
	}

	/**
	 * @param integers
	 * @param position
	 * @return
	 */
	public List<Integer[]> getPermutation(Integer[] integers, int position) {
		int temp;
		List<Integer[]> returnList	= new ArrayList<Integer[]>();
		if((integers.length-1)==position){
			returnList.add(integers.clone());
		}else{
			//12 // 21
			for(int index = position; index<integers.length; index++){
				//Swap the items in index with the position
				temp = integers[index];
				integers[index] = integers[position];
				integers[position] = temp;
				returnList.addAll(getPermutation(integers, position+1));
				//Swap back so that  we are ready for next permutation
				temp = integers[index];
				integers[index] = integers[position];
				integers[position] = temp;
			}
		}
		return returnList;
	}
}