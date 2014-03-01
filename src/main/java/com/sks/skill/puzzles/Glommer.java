package com.sks.skill.puzzles;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Sabith_ks
 *
 *https://www.youtube.com/watch?v=wbp-3BJWsU8#t=2084
 * @param <T>
 */
public class Glommer<T> {

	public static void main(String[] args){
		List<String> lists	= Arrays.asList("1", "2", "3");
		System.out.println(new Glommer().glom(lists));
	}

	public String glom(Collection<?> objs){
		String result	= "";
		for(Object o: objs){
			result	+= o;
		}
		return result;
	}
	
	int glom(List<Integer> ints){
		int resultInt	= 0;
		for(int i : ints){
			resultInt += i;
		}
		return resultInt;
	}
}
