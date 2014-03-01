package com.sks.skill.designPattern.abstractFactory;

import com.sks.skill.designPattern.factory.Shape;
import com.sks.skill.designPattern.factory.ShapeType;

public abstract class AbstractFactory {

	abstract Color getColor(ColorType colorType);
	
	abstract Shape getShape(ShapeType shapetype); 
}