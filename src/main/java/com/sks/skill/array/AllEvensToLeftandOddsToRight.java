package com.sks.skill.array;

import java.util.Arrays;

/**
 * @author Sabith_ks
 *
 * Inspired by 
 */
public class AllEvensToLeftandOddsToRight {
	
	public static void main(String[] args){
		Integer[] output = new AllEvensToLeftandOddsToRight().sort(new Integer[]{1, 12,3, 34,54,6,3,12,23});
		System.out.println(Arrays.asList(output));
	}

	public Integer[] sort(Integer[] integers) {
		if(integers==null){
			throw new IllegalArgumentException("The input should not be null");
		}
		
		int i =0,
			j = integers.length-1;
		while(i<j){
			if(integers[i]%2==0){
				//this is even, so move to next
				i++;
			}
			if(integers[j]%2!=0){
				j--;
			}
			//here we are , we have the odd at left, even at right. swap
			if(i<j){
				
				//swap after making sure that we have not crossed the limits
				integers[i] = integers[j]+integers[i] - (integers[j]=integers[i]);
			}
		}
		return integers;
	}
}