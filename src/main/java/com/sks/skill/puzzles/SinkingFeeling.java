package com.sks.skill.puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sabith_ks
 *the bridge cant create a Object[] to String[]
 *So Use Collection<T> instead of T... 
 */
public class SinkingFeeling extends Sink<String>{
	
	private final List<String> list	= new ArrayList<String>();

	@Override
	void add(String... elements) {
		list.addAll(Arrays.asList(elements));
	}
	
	public String toString(){
		return this.list.toString();
	}
	
	public static void main(String[] args){
		Sink<String> ss	= new SinkingFeeling();
		ss.addUnlessNull("null", null);
		System.out.println(ss);
	}

}
