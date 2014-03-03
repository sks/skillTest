package com.sks.skill.charsearch;

import java.util.Arrays;

/**
 * @author Sabith_ks
 *
 */
public class CharSearch {

	
	public static void main(String[] args){
		System.out.println("x c "+ new CharSearch().search(new char[]{'c', 'f', 'j', 'p', 'v'}, 'x'));
		System.out.println("a c "+ new CharSearch().search(new char[]{'c', 'f', 'j', 'p', 'v'}, 'a'));
		System.out.println("c f "+ new CharSearch().search(new char[]{'c', 'f', 'j', 'p', 'v'}, 'c'));
		System.out.println("k p "+new CharSearch().search(new char[]{'c', 'f', 'j', 'p', 'v'}, 'k'));
		System.out.println("v c "+ new CharSearch().search(new char[]{'c', 'f', 'j', 'p', 'v'}, 'v'));
	}

	/**
	 * @param charArray
	 * @param searchChar
	 */
	private char search(char[] charArray, char searchChar) {
		Arrays.sort(charArray);
		int low=0, 
				high = charArray.length-1, 
				middle= low + (high-low)/2;
				
		while(low<high){
			//if the search char is less than the middle one
//			System.out.println(charArray[low]+"  "+charArray[middle]+"  "+charArray[high]+" "+searchChar);
			middle= low + (high-low)/2;
//			System.out.println(charArray[middle] + "  "+searchChar);
			if(charArray[high]<=searchChar){
				//out of bound 
				middle = 0;
				break;
			} else if(charArray[middle]==searchChar){
				middle++;
				break;
			}else if(charArray[middle]<searchChar){
				low	= middle+1;
			}else if(charArray[middle]>searchChar){
				high	= middle;
			}
//			System.out.println(low+" "+middle+" "+ charArray.length);
		}
		middle = (middle>=charArray.length) ? 0 : middle;
		return charArray[middle];
	}
}
