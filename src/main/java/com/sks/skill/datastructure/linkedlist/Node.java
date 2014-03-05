package com.sks.skill.datastructure.linkedlist;

public class Node<T> {
	
	T element;
	
	Node<T> next;

	@Override
	public String toString() {
		return element+" -> "+next;
	}

}
