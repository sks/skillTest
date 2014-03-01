package com.sks.skill.designPattern.abstractFactory;

import com.sks.skill.designPattern.factory.Shape;
import com.sks.skill.designPattern.factory.ShapeType;

/**
 * @author Sabith_ks
 *
 */
public class ColorFactory extends AbstractFactory{

	/**
	 * @param color
	 * @return
	 */
	public Color getColor(ColorType color){
		switch(color){
		case RED:
			return new Red();
		case BLUE:
			return new Blue();
		case GREEN:
			return new Green();
		default:
			return null;
		}
	}

	@Override
	Shape getShape(ShapeType shapetype) {
		// TODO Auto-generated method stub
		return null;
	}

}
