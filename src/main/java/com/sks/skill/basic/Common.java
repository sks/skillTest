package com.sks.skill.basic;

public class Common {
	
	public static final String terminator	 = "0";

	public static void createBreak() {
		String character	= "-";
		for(int i =  0 ; i <5; i++){
			character+= character;
		}
		System.out.println(character);
		
	}
}
