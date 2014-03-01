package com.sks.skill.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
	
	public static void main(StringChecks[] args) throws IOException{
		String input = "-1";
		Palindrome palindrome = new Palindrome();
		Common.createBreak();
		System.out.println("Enter "+Common.terminator+" whenver you want to exit");
		Common.createBreak();
		do{
			System.out.print("Please enter the String : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input	= br.readLine();
			if(input.equals(Common.terminator)){
				System.out.println("Program will now exit");
				break;
			}
			
			System.out.println("Palindrome check for "+ input +" : "+palindrome.isPalindrome(input));
			Common.createBreak();
		}while(! input.equals(Common.terminator));
		
		
	}

	private boolean isPalindrome(String string) {
		boolean isPalindrome	= true;
		for(int i=0; i<string.length()/2 ; i++ ){
			char firstLetter	= string.charAt(i);
			char lastLetter		= string.charAt(string.length()-1-i);
			if(firstLetter != lastLetter){
				isPalindrome =false;
				break;
			};
		}
		return isPalindrome;
	}
}
