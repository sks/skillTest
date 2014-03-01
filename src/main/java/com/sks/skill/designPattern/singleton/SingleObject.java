package com.sks.skill.designPattern.singleton;

/**
 * @author Sabith_ks
 *
 */
public class SingleObject {
	
	/**
	 * Private instance of self  
	 */
	private static SingleObject instance;
	
	/**
	 *  Make the constructor private
	 */
	private SingleObject(){}
	
	/**
	 * @return the one and only instance that would be ever created
	 */
	public static SingleObject getInstance(){
		if(instance==null){
			//Only created once. and this message should come only once
			System.out.println("The object single object is created");
			instance	= new SingleObject();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public void sayHello(){
		System.out.println("I said Hello");
	}
	
	@Override
	public String toString(){
		return "SingleObject[]";
	}

}
