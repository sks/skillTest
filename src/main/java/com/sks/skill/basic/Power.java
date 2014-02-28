package com.sks.skill.basic;

/**
 * @author Sabith_ks
 *
 */
/**
 * @author Sabith_ks
 *
 */
public class Power {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(new Power().checkIfPowerOf2(8));
	}

	/**
	 * @param number
	 * @return
	 */
	private boolean checkIfPowerOf2(int number) {
		return ((number & -number) == number);
	}

}
