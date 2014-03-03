package com.sks.skill.kadane;

/**
 * @author Sabith_ks
 *
 */
public class Kadane {
	
	public static void main(String[] args){
		System.out.println(new Kadane().maxSumOfContinuousSubsequence(new Integer[]{-1, 2, 0, -32, -6, -7, -1}, false));
		System.out.println(new Kadane().maxSumOfContinuousSubsequence(new Integer[]{-1, 2, 0, -32, -6, -7, -1}, true));
	}

	private int maxSumOfContinuousSubsequence(Integer[] integers, boolean allowNegative) {
		int maxEndingTillNow	= (allowNegative) ? integers[0] : 0,
				maxSoFar	= maxEndingTillNow;
		for(int number: integers){
			//System.out.println("B4 " +number+"  "+maxEndingTillNow+"  "+maxSoFar);
			maxEndingTillNow	= Math.max(maxEndingTillNow, maxEndingTillNow+number);
			maxSoFar			= Math.max(maxEndingTillNow, maxSoFar);
			//System.out.println("AFTER " +number+"  "+maxEndingTillNow+"  "+maxSoFar);
		}
		return maxSoFar;
	}

}
