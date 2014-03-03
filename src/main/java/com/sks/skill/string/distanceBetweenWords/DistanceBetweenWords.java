package com.sks.skill.string.distanceBetweenWords;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sabith_ks
 *
 */
public class DistanceBetweenWords {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		new DistanceBetweenWords().calculateDistance("Hello how are you", "hello", "are", false);
	}

	/**
	 * @param sentance
	 * @param firstString
	 * @param secondString
	 * @param ignoreCase
	 * @return
	 */
	private int calculateDistance(String sentance, String firstString, String secondString, boolean ignoreCase) {
		int returnInt	= -1;
		if(! hasText(sentance) || ! hasText(firstString) || !hasText(secondString)){
			throw new IllegalArgumentException("All the String should have some string value");
		}
		//if ignore case
		if(ignoreCase){
			sentance	= sentance.toLowerCase();
			firstString	= firstString.toLowerCase();
			secondString	= secondString.toLowerCase();
		}
		//
		List<String> sentanceArray	= Arrays.asList(sentance.split(" "));
		int secondStringIndex	= sentanceArray.indexOf(secondString);
		int firstStringIndex	= sentanceArray.indexOf(firstString);
		if(firstStringIndex!=-1 && secondStringIndex!=-1){
			returnInt = secondStringIndex - firstStringIndex;
			returnInt	= Math.abs(returnInt);
		}
		System.out.println("Distance b/w '"+firstString+"' & '"+secondString+"' in the sentance '"+sentance+"' is "+returnInt);
		return returnInt;
	}

	/**
	 * @param sentance
	 * @return true if the string contains some text
	 */
	private boolean hasText(String sentance) {
		return sentance!=null && sentance.trim().length()!=0;
	}

}
