package com.sks.skill.basic.garbageCollection;

/**
 * @author Sabith_ks
 * Inspired by https://www.youtube.com/watch?v=0YebJQSZE_E
 * JVM args : -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/
 *
 */
public class OutOfMemory {

	public static void main(String[] args){
		char[] character	=	new char[(int) 99999999999999999L];
	}
}
