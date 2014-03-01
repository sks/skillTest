package com.sks.skill.designPattern.abstractFactory;

import com.sks.skill.basic.Common;
import com.sks.skill.designPattern.factory.ShapeType;

/**
 * @author Sabith_ks
 * inspired by http://www.tutorialspoint.com/design_pattern/design_pattern_tutorial.pdf
 * 
 * Abstract Factory patterns works around a super-factory which creates other factories. 
 * This Factory is also called as Factory of factories. 
 * Classification : Creational pattern.
 * In Abstract Factory pattern an interface is responsible for creating a factory of related objects,
 * without explicitly specifying their classes. Each generated factory can give the objects as per the 
 * Factory pattern. 

 *
 */
public class AbstractFactoryDemo {

	public static void main(String[] args){
		//Shape Type
		AbstractFactory abstractFactory	= FactoryProducer.getFactory("SHAPE");
		for(ShapeType shapeType : ShapeType.values()){
			Common.createBreak();
			System.out.println(abstractFactory.getShape(shapeType));
		}
		//Color
		AbstractFactory colorFactory	= FactoryProducer.getFactory("COLOR");
		for(ColorType colorType : ColorType.values()){
			Common.createBreak();
			System.out.println(colorFactory.getColor(colorType));
		}
		Common.createBreak();
		
		
		
	}
}
