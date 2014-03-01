package com.sks.skill.designPattern.abstractFactory;

public class Green implements Color{

	@Override
	public void fill() {
		System.out.println("Filled with Green");
	}
	
	@Override
	public String toString() {
		return "Green []";
	}

}
