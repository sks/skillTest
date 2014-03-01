package com.sks.skill.designPattern.factory;

/**
 * @author Sabith_ks
 *
 */
public class Rectangle implements Shape{

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	private double height;
	
	private double width;

	public Rectangle(double height, double width){
		this.height	= height;
		this.width	= width;
	}

	@Override
	public void draw() {
		System.out.println("Drawing the rectangle with width "+width + " and  height "+height);
	}

	@Override
	public double perimeter() {
		return 2*(height + width);
	}
	
	@Override
	public String toString(){
		return "Rectange with width "+this.getWidth()+" & height "+this.getHeight();
	}
}
