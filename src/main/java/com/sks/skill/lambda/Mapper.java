package com.sks.skill.lambda;

/**
 * @author Sabith_ks
 *
 * @param <T> you give a class T , you get back a value U, how the conversion is done is upto you
 * @param <U>
 */
public interface Mapper<T, U> {
	
	public U map(T t);

}
