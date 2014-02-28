package com.sks.skill.lambda;

public class Person {

	private String name;
	
	private String email;
	
	private int age;
	
	private Sex sex;
	
	private PhoneNumber homeNumber;
	
	private PhoneNumber mobileNumber;

	public Person(String name, String email, int age, Sex sex) {
		this.name	= name;
		this.email	= email;
		this.age	= age;
		this.sex	= sex;
		this.mobileNumber	= new PhoneNumber(name+"_mobile");
		this.homeNumber		= new PhoneNumber(name+"_home"); 
	}
	
	public Sex getSex() {
		return sex;
	}



	public void setSex(Sex sex) {
		this.sex = sex;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PhoneNumber getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(PhoneNumber homeNumber) {
		this.homeNumber = homeNumber;
	}

	public PhoneNumber getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(PhoneNumber mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", age=" + age
				+ ", sex=" + sex + ", homeNumber=" + homeNumber
				+ ", mobileNumber=" + mobileNumber + "]";
	}

	
	
}
