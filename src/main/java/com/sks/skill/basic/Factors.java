package com.sks.skill.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factors {

	/**
	 * @param number
	 * @return
	 */
	public List<Integer> getFactors(int number){
		if(number==0){
			throw new IllegalArgumentException("Zero has infinite factors");
		}
		List<Integer> returnList	= new ArrayList<Integer>();
		returnList.addAll(Arrays.asList(1, number, -1, -1*number));
		int factor	= 2;
		while(factor<=number/2){
			if(number%factor==0){
				returnList.add(factor);
				//Add Negative
				returnList.add(-1 * factor);
			}
			factor++;
		}
		return returnList;
	}


	/**
	 * @param args
	 */
	public void main(String[] args){
		System.out.println(new Factors().getFactors(32));
		System.out.println(new Factors().getPrimeFactor(40));
	}

	/**
	 * @param number
	 * @return list of prime factors
	 */
	public List<Integer> getPrimeFactor(int number){
		if(number==0){
			throw new IllegalArgumentException("Zero has infinite factors");
		}
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= number / i; i++) {
			while (number % i == 0) {
				factors.add(i);
				number /= i;
			}
		}
		if (number > 1) {
			factors.add(number);
		}
		return factors;

	}
}
