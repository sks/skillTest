package com.sks.skill.nestedInteger;


/**
 * @author Sabith_ks
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		NestedInteger nestedInteger = null;
		//{{1,1},2,{1,1}}
		getSum(nestedInteger, 1);
	}

	private static int getSum(NestedInteger nestedInteger, int weight) {
		if(nestedInteger.isInteger()){
			return  weight*nestedInteger.getInteger();
		}
		int returnInt	= 0;
		for(NestedInteger nInteger : nestedInteger.getList()){
			returnInt =	getSum(nInteger, weight+1);
		}
		return returnInt;
		
		
	}
}
