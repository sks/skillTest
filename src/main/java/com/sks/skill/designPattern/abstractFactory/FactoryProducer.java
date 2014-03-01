package com.sks.skill.designPattern.abstractFactory;

/**
 * @author Sabith_ks
 *
 */
public class FactoryProducer {
	
	/**
	 * @param choice
	 * @return
	 */
	public static AbstractFactory getFactory(String choice){ 
		if(choice.equalsIgnoreCase("SHAPE")){ 
			return new ShapeFactory(); 
		} else if(choice.equalsIgnoreCase("COLOR")){ 
			return new ColorFactory(); 
		} 
		return null; 
	} 
}