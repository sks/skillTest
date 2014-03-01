package com.sks.skill.designPattern.abstractFactory;

public class Red implements Color{

	@Override
	public void fill() {
		System.out.println("Filled with Red");
	}

	@Override
	public String toString() {
		return "Red []";
	}
	
	
}
