package com.sks.skill.lambda;

public class Employee extends Person{

	private boolean permanent;

	public Employee(String name, String email, int age, Sex sex, boolean isPermanent) {
		super(name, email, age, sex);
		this.permanent	= isPermanent;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	
}
