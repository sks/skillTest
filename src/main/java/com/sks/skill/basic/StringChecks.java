package com.sks.skill.basic;

/**
 * @author Sabith_ks
 *
 */
public class StringChecks {

	public static void main(String[] args){
		new StringChecks().equalityChecks();
	}

	/**
	 * 
	 */
	private void equalityChecks() {
		String abc	= "abc";
		String ABC	= new String("abc");
		System.out.println("Before : ");
		System.out.println("Both the object points to same : "+abc==ABC);
		System.out.println(abc.equals(ABC));
		ABC	= "abc";
		System.out.println("After : ");
		System.out.println("Both the object points to same : "+abc==ABC);
		System.out.println(abc.equals(ABC));
		
	}
}
