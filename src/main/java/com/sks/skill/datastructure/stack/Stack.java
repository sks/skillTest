/**
 * 
 */
package com.sks.skill.datastructure.stack;

import java.util.Arrays;

/**
 * @author Sabith_ks
 *
 */
public class Stack<T> {

	private Object[] stack;

	private int size;

	private static final int DEFAULT_CAPACITY = 10;

	/**
	 * @param stackSize
	 */
	public Stack(int stackSize) {
		stack	= new Object[DEFAULT_CAPACITY];
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> stack	= new Stack<Integer>(10);
		//Add things to stacks
		for(int index=0; index< DEFAULT_CAPACITY; index++){
			stack.push(index);
		}
		//print the stack
		System.out.println(stack.toString());
		//peak the stack
		System.out.println("Peak-ed : " +stack.peak());
		//pop back the stack
		for(int index=0; index< DEFAULT_CAPACITY; index++){
			System.out.println("Pop-ed : " +stack.pop());
		}
		System.out.println(stack.toString());
	}

	@Override
	public String toString() {
		return "Stack [stack=" + Arrays.toString(stack) + ", size=" + size
				+ "]";
	}

	/**
	 * @param t
	 * add element to the stack
	 */
	public void push(T t) {
		if(size == stack.length){
			increaseCapacity();
		}
		stack[size++]= t;
	}


	/**
	 * @return the element on top of the stack
	 */
	public Object peak(){
		if(size==0){
			return null;
		}
		return stack[size-1];
	}

	/**
	 * @return
	 */
	public Object pop(){
		if(size==0){
			return null;
		}
		Object object	= stack[--size];
		stack[size] = null;
		return object;
	}

	/**
	 * double the capacity 
	 */
	private void increaseCapacity() {
		int newSize = stack.length * 2;
		stack = Arrays.copyOf(stack, newSize);
	}

}
