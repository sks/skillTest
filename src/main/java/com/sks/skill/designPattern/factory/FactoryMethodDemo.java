package com.sks.skill.designPattern.factory;

import com.sks.skill.basic.Common;

/**
 * @author Sabith_ks
 * inspired by demo : http://www.tutorialspoint.com/design_pattern/design_pattern_tutorial.pdf
 */
public class FactoryMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		//Break lines
		Common.createBreak();
		for(ShapeType shapeType : ShapeType.values()){
			//Shape type
			System.out.println(ShapeFactory.getShape(shapeType));
			//Common Break
			Common.createBreak();
		}
		
	}
}
