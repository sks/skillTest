package com.sks.skill.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sabith_ks
 * testing functionality as per video https://www.youtube.com/watch?v=bzO5GSujdqI
 * parameterize behavior
 */
public class RoboCall {

	private static List<Person> listOfPerson	= new ArrayList<Person>();

	static{
		Person	 pa	= new Person("a", "a@a.com", 1, Sex.MALE);
		Person	 pb	= new Person("b", "b@b.com", 2, Sex.FEMALE);
		Person	 pc	= new Person("c", "c@c.com", 3, Sex.MALE);
		Person	 pd	= new Person("d", "d@d.com", 4, Sex.MALE);
		Person	 pe	= new Person("e", "e@e.com", 5, Sex.FEMALE);
		Person	 pm	= new Person("m", "m@m.com", 21, Sex.MALE);
		Person	 pz	= new Person("z", "z@z.com", 26, Sex.FEMALE);
		Person	 tooOld	= new Person("zzzz", "zzz@zzzz.com", 76, Sex.MALE);
		listOfPerson	= Arrays.asList(pa, pb, pc, pd, pe, pm, pz, tooOld);
	}

	public static void main(String[] args){
		isEligibleToDrink();
		isEligibleToDrive();
		isLiving();
		needNotGotoSchool();
		canVote();
		isEligibleForSelectiveService();

	}

	private static int callMatchingPerson(String forWhat, Predicate<Person> pred) {
		int returnInt	= 0;
		for(Person person : listOfPerson){
			//Test the person for the interface
			if(pred.testPerson(person)){
				returnInt++;
			}
		}
		System.out.println("Number of persons are eligible for "+forWhat+ " : "+returnInt);
		return returnInt;

	}

	/**
	 * 
	 */
	private static void isEligibleToDrink(){
		//For drinks : age > 22
		callMatchingPerson("Drinking", new Predicate<Person>() {

			@Override
			public boolean testPerson(Person t) {
				return t.getAge()>22;
			}
		});


	}

	/**
	 * 
	 */
	private static void isEligibleToDrive(){
		//For driving : age> 18 and age < 49
		callMatchingPerson("Driving", new Predicate<Person>() {

			@Override
			public boolean testPerson(Person person) {
				return person.getAge()>18 && person.getAge()<49;
			}
		});
	}

	/**
	 * 
	 */
	public static void isLiving(){
		//For living : age>0
		callMatchingPerson("Living", new Predicate<Person>() {

			@Override
			public boolean testPerson(Person person) {
				return person.getAge()>0;
			}
		});
	}

	public static void needNotGotoSchool(){
		//For noSchool: age < 4 or age > 43
		callMatchingPerson("Not going to school ", new Predicate<Person>() {

			@Override
			public boolean testPerson(Person person) {
				return person.getAge()<4 || person.getAge()>43;
			}
		});
	}

	public static void canVote(){
		//for vote : age > 21
		callMatchingPerson("Voting", new Predicate<Person>() {

			@Override
			public boolean testPerson(Person person) {
				return person.getAge()>21;
			}
		});
	}

	public static void isEligibleForSelectiveService(){
		callMatchingPerson("Selective Service ", new Predicate<Person>() {

			@Override
			public boolean testPerson(Person person) {
				return person.getAge()>=18 &&
						person.getSex() == Sex.MALE &&
						person.getAge()<= 25;
			}
		});
	}
}
