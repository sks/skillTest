package com.sks.skill.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
	 * @param source : Source of the persons
	 * @param forWhat : what is the purpose
	 * @param pred
	 * @param block
	 * @param mapper
	 * @return
	 * 
	 * What this does
	 * Source -> Filter -> Mapper -> Apply
	 * Iterate through the source, 
	 * Filter the resource
	 * Use Mapper to find out on what the action has to be taken
	 * use Apply to call the required function call
	 */
	private  int processMatchingPerson( 
			Iterable<Person> source,
			String forWhat, 
			Predicate<Person> pred, 
			Block<PhoneNumber> block,
			Mapper<Person, PhoneNumber> mapper) {
		//The count of persons on which we have applied some logic
		int returnInt	= 0;
		//Iterate through the iterable of persons
		for(Person person : source){

			//Test the person for the interface , Filter
			if(pred.testPerson(person)){

				//Increment
				returnInt++;

				//Apply a block of code 
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
		listOfPerson
		.stream()
		.parallel()
		.filter((person) -> person.getAge()>22)
		.map((person) -> {
			return person.getHomeNumber();
		})
		.forEach((person) -> {
			roboCall(person);
		});

		//Text to mobile number
		listOfPerson
		.stream()
		.parallel()
		.filter((person) -> person.getAge()>22)
		.map((person) -> {
			return person.getMobileNumber();
		})
		.forEach((person) -> {
			roboText(person);
		});
	}

	/**
	 * 
	 */
	private static void isEligibleToDrive(){
		//For driving : age> 18 and age < 49
		listOfPerson.stream().filter(
				(person) -> person.getAge()>18 && person.getAge()<49
				)
				.map((person) -> {
					return person.getMobileNumber();
				})
				.forEach((person) -> roboCall(person));
	}

	/**
	 * 
	 */
	public static void isLiving(){
		//For living : age>0
		listOfPerson.stream().filter((person) -> person.getAge() > 0)
		.map((person) -> {return person.getMobileNumber();})
		.forEach((person) -> {roboCall(person);}); 
	}

	/**
	 * 
	 */
	public static void needNotGotoSchool(){
		//For noSchool: age < 4 or age > 43
		listOfPerson.stream().filter((person) -> person.getAge()<4 || person.getAge()>43)
		.map((person) -> {return person.getMobileNumber();})
		.forEach((person) -> {roboCall(person);}); 
	}

	/**
	 * 
	 */
	public static void canVote(){
		//for vote : age > 21
		listOfPerson.stream()
		.filter((person) -> person.getAge()>21)
		.map((person) -> {return person.getMobileNumber();})
		.forEach((person) -> {roboCall(person);});
	}

	/**
	 * 
	 */
	public static void isEligibleForSelectiveService(){
		listOfPerson.stream()
		.filter((person) -> person.getAge()>=18 && person.getSex() == Sex.MALE && person.getAge()<= 25)
		.map((person) -> {return person.getMobileNumber();})
		.forEach((person) -> {roboCall(person);});
	}
}
