package com.sks.skill.designPattern.singleton;

/**
 * @author Sabith_ks
 * Inspired by : http://www.tutorialspoint.com/design_pattern/design_pattern_tutorial.pdf
 * 
 * Classfication : Creational design Pattern
 * Only one class is created in the whole scope
 *
 */
public class SingletonDemo {

	public static void main(String[] args){
		//Not possible to create the instance as the constructor is private
		//new SingleObject();

		//
		SingleObject.getInstance().sayHello();
		
		SingleObject.getInstance().sayHello();
	}
}
