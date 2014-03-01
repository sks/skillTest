package com.sks.skill.designPattern.factory;

/**
 * @author Sabith_ks
 *
 */
public class Circle implements Shape{
	
	private double radius;
	
	/**
	 * @param radius
	 */
	public Circle(double radius){
		this.radius	= radius;
	}

	@Override
	public void draw() {
		System.out.println("Drawing circle");
	}

	@Override
	public double perimeter() {
		return 2*Math.PI*radius;
	}
	
	@Override
	public String toString(){
		return "Circle with radius "+this.getRadius();
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}