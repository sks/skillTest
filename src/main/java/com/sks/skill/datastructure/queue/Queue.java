package com.sks.skill.datastructure.queue;

import java.util.Arrays;


public class Queue<T> {

	private Object[] queue;
	
	private static int DEFAULT_SIZE_COUNT	= 10;
	
	private int size;
	
	public Queue(){
		queue	= new Object[DEFAULT_SIZE_COUNT];
	}
	
	
	public static void main(String[] args){
		Queue<Integer> q  =  new Queue<Integer>();
		//add things to the queue
		for(int i=0; i < DEFAULT_SIZE_COUNT; i++){
			q.add(i);
		}
		q.add(123123);
		System.out.println(q);
		//Peek into the queue
		System.out.println(q.peek());
		for(int i=0; i < DEFAULT_SIZE_COUNT; i++){
			System.out.println(q.remove());
		}
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q);
	}
	
	


	/**
	 * @return the first element to be removed from the array
	 */
	private Object peek() {
		if(size==0){
			return null;
		}
		return  queue[0];
	}


	/**
	 * @return removes the first element from the array
	 */
	public Object remove() {
		Object obj	= this.peek();
		if(obj == null){
			return null;
		}
		queue	= Arrays.copyOfRange(queue, 1, size--);
		return obj;
	}


	/**
	 * @param element
	 */
	public void add(int element) {
		if(size>=queue.length){
			increaseCapacity();
		}
		queue[size++] = element;
	}


	@Override
	public String toString() {
		return "Queue [queue=" + Arrays.toString(Arrays.copyOfRange(queue, 0, size)) + ", size=" + size
				+ "]";
	}


	/**
	 * 
	 */
	private void increaseCapacity() {
		queue	= Arrays.copyOf(queue, queue.length*2);
	}
}
