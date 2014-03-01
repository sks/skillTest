package com.sks.skill.puzzles;

/**
 * @author Sabith_ks
 *
 * https://www.youtube.com/watch?v=wbp-3BJWsU8#t=2667
 * Never use lower case l to indicate a long, always use capital L
 * Never preceed a int with 0, unless you want to convert to octal 
 * 
 */
public interface Elementary {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		System.out.print(12345 + 5432l); //its a l and not 1
		System.out.print(" ");
		System.out.println("asdas "+01234); //number starting with 0
		System.out.print(01234 + 43210 );
	}
}
