package com.sks.skill.basic;

/**
 * @author Sabith_ks
 * An object is considered immutable if its state cannot change after it is constructed. 
 * 
 * all the properties are final.
 * there are no setters
 * 
 * Useful in concurrent applications
 */
public final class ImmutableClass {
	
	private final String name;
	
	private final String hexCode;
	
	public ImmutableClass(String name, String hexCode){
		this.name	= name;
		this.hexCode	= hexCode;
	}

	public String getName() {
		return name;
	}

	public String getHexCode() {
		return hexCode;
	}

	
	public static void main(String[] args){
		ImmutableClass immutableClass	= new ImmutableClass("test", "123");
		System.out.println(immutableClass);
	}

	@Override
	public String toString() {
		return "ImmutableClass [name=" + name + ", hexCode=" + hexCode + "]";
	}
}
