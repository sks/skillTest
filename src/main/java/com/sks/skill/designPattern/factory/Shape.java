package com.sks.skill.designPattern.factory;

public interface Shape {
	
	/**
	 * Draws the shape
	 */
	public void draw();
	
	/**
	 * @return the perimeter of the shape
	 */
	public double perimeter();
}