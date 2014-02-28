package com.sks.skill.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sks.skill.basic.Common;

/**
 * @author Sabith_ks
 * Testing functionality as per video https://www.youtube.com/watch?v=bzO5GSujdqI
 * Parameterize behavior
 * Compiler has to do the Type Inference while checking the lambda
 * This is not dynamic typing (Java is still Statically typed language)
 *  
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

	private static void roboCall(PhoneNumber phoneNumber){
		System.out.println("Called "+phoneNumber);
	}

	private static void roboText(PhoneNumber phoneNumber){
		System.out.println("Texted "+phoneNumber);
	}

	/**
	 * @param forWhat
	 * @param predicate
	 * @return
	 */
	private static int processMatchingPerson(String forWhat, 
			Predicate<Person> pred, 
			Block<PhoneNumber> block,
			Mapper<Person, PhoneNumber> mapper) {
		int returnInt	= 0;
		for(Person person : listOfPerson){
			//Test the person for the interface
			if(pred.testPerson(person)){
				returnInt++;
				block.apply(mapper.map(person));
			}
		}
		System.out.println("Number of persons are eligible for "+forWhat+ " : "+returnInt);
		Common.createBreak();
		return returnInt;
	}

	/**
	 * 
	 */
	private static void isEligibleToDrink(){
		//For drinks : age > 22
		processMatchingPerson("Drinking", (person) -> person.getAge()>22, 
				(person) -> {
					roboCall(person);
				},
				(person) -> {
					return person.getHomeNumber();
				}
				);
		//Text to mobile number
		processMatchingPerson("Drinking", (person) -> person.getAge()>22, 
				(person) -> {
					roboText(person);
				},
				(person) -> {
					return person.getMobileNumber();
				}
				);


	}

	/**
	 * 
	 */
	private static void isEligibleToDrive(){
		//For driving : age> 18 and age < 49
		processMatchingPerson("Driving", (person) -> person.getAge()>18 && person.getAge()<49,
				(person) -> {
					roboCall(person);
				},
				(person) -> {
					return person.getMobileNumber();
				});
	}

	/**
	 * 
	 */
	public static void isLiving(){
		//For living : age>0
		processMatchingPerson("Living", (person) -> person.getAge()>0,
				(person) -> {
					roboCall(person);
				},
				(person) -> {
					return person.getMobileNumber();
				});
	}

	/**
	 * 
	 */
	public static void needNotGotoSchool(){
		//For noSchool: age < 4 or age > 43
		processMatchingPerson("Not going to school ", (person) -> person.getAge()<4 || person.getAge()>43,
				(person) -> {
					roboCall(person);
				},
				(person) -> {
					return person.getMobileNumber();
				});
	}

	public static void canVote(){
		//for vote : age > 21
		processMatchingPerson("Voting", (person) -> person.getAge()>21,
				(person) -> {
					roboCall(person);
				},
				(person) -> {
					return person.getMobileNumber();
				});
	}

	public static void isEligibleForSelectiveService(){
		processMatchingPerson("Selective Service ",  
				(person) -> person.getAge()>=18 && person.getSex() == Sex.MALE && person.getAge()<= 25,
				(person) -> {
					roboCall(person);
				},
				(person) -> {
					return person.getMobileNumber();
				});
	}
}
