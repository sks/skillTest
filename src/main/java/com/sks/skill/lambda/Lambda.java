package com.sks.skill.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sks.skill.basic.Common;

/**
 * @author Sabith_ks
 *
 */
public class Lambda {

	public static void main(String[] args){
		Person sks	= new Person("sks", "sks@sks.com", 25, Sex.FEMALE);
		Person stp	= new Person("stp", "stp@stp.com", 22, Sex.MALE);
		
		List<Person> shortListOfPerson	= Arrays.asList(sks, stp);
		sortInOldWay(shortListOfPerson);
		sortUsingLambda(shortListOfPerson);
		
	}

	/**
	 * @param shortListOfPerson
	 */
	private static void sortUsingLambda(List<Person> shortListOfPerson) {
		Common.createBreak();
		System.out.println("Sorting using the old way ");
		System.out.println("at 0 index "+ shortListOfPerson.get(0));
		//Now sort it , the old way (Not using the lambda's)
		Comparator<Person> personComparitor	= (Person o1, Person o2) -> o1.getName().compareTo(o2.getName());
		//Just one line of stating the things
		Collections.sort(shortListOfPerson, personComparitor);
		System.out.println("After sorting using lambda method at 0 index "+ shortListOfPerson.get(0));
	}

	private static void sortInOldWay(List<Person> shortListOfPerson) {
		Common.createBreak();
		System.out.println("Sorting using the old way ");
		System.out.println("at 0 index "+ shortListOfPerson.get(0));
		//Now sort it , the old way (Not using the lambda's)
		Collections.sort(shortListOfPerson, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		System.out.println("After sorting using the old method at 0 index "+ shortListOfPerson.get(0));
		
	}
}
