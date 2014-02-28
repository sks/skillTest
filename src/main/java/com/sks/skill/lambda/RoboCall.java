package com.sks.skill.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		//Some stream usage.
		streamsCustomUsages();
		streamReduceOperation();

	}

	private static void streamReduceOperation() {
		List<Integer> integerList	= Arrays.asList(1,2,3,4,5,6,7,8,9);
		int sum = integerList.stream()
				.parallel()
				.reduce(0, (x,y)-> x+y);
		System.out.println(sum);
		
		
	}

	private static void streamsCustomUsages() {
		List<String> stringList	= Arrays.asList("A", "B", "C", "D", "E", "F", "F", "F", "A");
		stringList
		.stream()//Make a stream out of this
		.distinct() //makes it unordered
		.skip(1) //Skips one element
		.forEach(s-> {System.out.println(s);});
		
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
	//private void processMatchingPerson(){}

	/**
	 * 
	 */
	private static void isEligibleToDrink(){
		//For drinks : age > 22
		listOfPerson
		.stream()
		.parallel()
		.filter((person) -> person.getAge()>22)
		.map((person) -> {return person.getHomeNumber();})
		.forEach((person) -> {roboCall(person);});

		//Text to mobile number
		listOfPerson
			.stream()
			.parallel()
			.filter((person) -> person.getAge()>22)
			.map((person) -> {return person.getMobileNumber();})
			.forEach((person) -> {roboText(person);});
	}

	/**
	 * 
	 */
	private static void isEligibleToDrive(){
		//For driving : age> 18 and age < 49
		listOfPerson.stream()
		.filter((person) -> person.getAge()>18 && person.getAge()<49)
		.map((person) -> {return person.getMobileNumber();})
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
