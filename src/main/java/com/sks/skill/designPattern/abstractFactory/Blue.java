package com.sks.skill.designPattern.abstractFactory;

public class Blue implements Color{

	@Override
	public void fill() {
		System.out.println("Filled with Blue");
	}
	
	@Override
	public String toString() {
		return "Blue []";
	}
}
