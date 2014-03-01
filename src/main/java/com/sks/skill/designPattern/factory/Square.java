package com.sks.skill.designPattern.factory;

public class Square extends Rectangle {

	public Square (double side){
		super(side, side);
	}

	@Override
	public void draw() {
		System.out.println("Drawing the square with side "+this.getHeight());
	}

	@Override
	public String toString(){
		return "Square with side "+this.getHeight();
	}
}