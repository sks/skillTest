package com.sks.skill.lambda;

public class PhoneNumber {

	private String number;
	

	public PhoneNumber(String number) {
		this.number	= number;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	@Override
	public String toString() {
		return "PhoneNumber [number=" + number + "]";
	}
	
}
