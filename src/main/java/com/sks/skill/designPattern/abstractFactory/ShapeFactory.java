package com.sks.skill.designPattern.abstractFactory;

import com.sks.skill.designPattern.factory.Circle;
import com.sks.skill.designPattern.factory.Rectangle;
import com.sks.skill.designPattern.factory.Shape;
import com.sks.skill.designPattern.factory.ShapeType;
import com.sks.skill.designPattern.factory.Square;

/**
 * @author Sabith_ks
 *
 */
public class ShapeFactory extends AbstractFactory{

	@Override
	Color getColor(ColorType colorType) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sks.skill.designPattern.abstractFactory.AbstractFactory#getShape(com.sks.skill.designPattern.factory.ShapeType)
	 */
	@Override
	Shape getShape(ShapeType shapeType) {
		switch (shapeType){
		case CIRCLE: 
			return  new Circle(0);
		case RECTANGLE:
			return new Rectangle(0, 0);
		case SQUARE:
			return new Square(0);
		default:
			return null;
		}
	}

}
