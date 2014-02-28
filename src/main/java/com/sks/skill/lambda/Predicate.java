package com.sks.skill.lambda;

/**
 * @author Sabith_ks
 * represented as (T) -> Boolean
 * This is a functional interface 
 *
 */
public interface Predicate<T> {

	boolean testPerson(T t);
}
