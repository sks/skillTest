package com.sks.skill.basic.oio;

public class Util {

	public static int transmogify(int data) {
		if(Character.isLetter(data)){
			//transpose the alphabets a->A, A->a
			return data ^ ' ';
		}
		return data;
	}
	
	public static void main(String[] args){
		System.out.println(Util.transmogify(1));
	}

}
