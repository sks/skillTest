package com.sks.skill.datastructure.hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
	
	Map<Person, String> persons	= new HashMap<Person, String>();
	
	
	HashMapMain(){
		persons.put(new Person("A"), "A");
		persons.put(new Person("B"), "B");
		persons.put(new Person("C"), "C");
		
	}
	
	public static void main(String[] args){
		new HashMapMain().process();
	}

	private void process() {
		//Adding a duplicate : 
		Person c	= new Person("C");
		String returnVal	= persons.put(c, "C_NEW");
		System.out.println(returnVal); //prints C
		//Again, add one more with the same C
		returnVal	= persons.put(new Person("C"), "C_NEW_2");
		System.out.println(returnVal); //prints C_NEW
		// With no HashCode implementation in Person, this return 5
		//With hashCode & Equals implementation, this return 3
		//With hashCode , but no equals implemetation, this return 5
		System.out.println(persons.size()); 
		System.out.println(persons.get(c));
	}

}
