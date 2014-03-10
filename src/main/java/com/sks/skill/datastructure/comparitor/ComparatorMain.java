package com.sks.skill.datastructure.comparitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sks.skill.lambda.Person;
import com.sks.skill.lambda.Sex;

/**
 * @author Sabith_ks
 *
 */
public class ComparatorMain {


	public static void main(String[] args){
		Person a	= new Person("A", "A@A.A", 1, Sex.MALE);
		Person b	= new Person("B", "B@B.B", 2, Sex.FEMALE);
		Person c	= new Person("C", "C@C.C", 3, Sex.MALE);
		Person d	= new Person("D", "D@D.D", 4, Sex.FEMALE);
		List<Person> persons	= new ArrayList<Person>();
		persons.add(a);
		persons.add(c);
		persons.add(b);

		persons.add(d);
		System.out.println(persons);
		//Using lambda for comparator
		//Sort by age
		Collections.sort(persons, ((Person p1, Person p2) -> {
			return p1.getAge() - p2.getAge();
		}));
		System.out.println("Sorted by age : "+persons);
		//Sort by Sex
		Collections.sort(persons, ((Person p1, Person p2) -> {
			return p1.getSex().compareTo(p2.getSex());
		}));
		System.out.println("Sorted by sex : "+persons);
	}
}
