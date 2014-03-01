package com.sks.skill.designPattern.factory;

/**
 * @author Sabith_ks
 * Classification : Creational Pattern
 * Client does not know how the object is created. 
 *
 */
public class ShapeFactory {

	/**
	 * @param shapeType
	 * @return
	 */
	public static Shape getShape(ShapeType shapeType){
		switch (shapeType){
		case CIRCLE: 
			Circle circle	=  new Circle(0);
			//The client does not know that I've set the radius to 100
			circle.setRadius(100);
			return circle;
		case RECTANGLE:
			return new Rectangle(0, 0);
		case SQUARE:
			return new Square(0);
		default:
			return null;
		}
	}

}
