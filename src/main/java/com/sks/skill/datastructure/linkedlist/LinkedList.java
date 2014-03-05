package com.sks.skill.datastructure.linkedlist;

public class LinkedList<E> {

	private Node<E> head;
	
	private Node<E> tail;
	
	private int counter;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	
	public Node<E> getHead() {
		return head;
	}

	public Node<E> getTail() {
		return tail;
	}

	/**
	 * @param elem
	 */
	public void addElement(E elem){
		if(head ==null ){
			head	= tail = new Node<E>();
			head.next	= null;
			head.element	= elem;
		} else{
			tail.next	= new Node<E>();
			tail		= tail.next;
			tail.element	= elem;
		}
		counter++;
	}
	
	public String toString(){
		return this.head.toString();
	}

	public void setHead(Node<E> head) {
		this.head	= head;
	}
}