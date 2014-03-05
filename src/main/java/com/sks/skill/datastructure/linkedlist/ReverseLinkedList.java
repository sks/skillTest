package com.sks.skill.datastructure.linkedlist;

import java.util.Random;

/**
 * @author Sabith_ks
 *
 */
public class ReverseLinkedList {

	private static Random random	= new Random();

	private static int max_list_size	= 10;

	/**
	 * @param args
	 */
	public static void main(String[] args){
		LinkedList<Integer> input	= getRandomLinkedList();
		new ReverseLinkedList().reverse(input);
	}

	/**
	 * @return
	 */
	private static LinkedList<Integer> getRandomLinkedList() {
		LinkedList<Integer>	returnList	= new LinkedList<Integer>();
		for(int index=0; index<=max_list_size; index++){
			returnList.addElement(random.nextInt());
		}
		return returnList;
	}

	/**
	 * @param input 
	 * 
	 */
	private LinkedList<Integer> reverse(LinkedList<Integer> input) {
		System.out.println(input);
		reverseNode(input, input.getHead());
		System.out.println(input);
		return input;

	}

	/**
	 * @param input
	 * @param node
	 */
	private void reverseNode(LinkedList<Integer> input, Node<Integer> node) {
		if(node==null){
			return;
		}else if(node.next == null){
			//This is the tail, make it the head
			input.setHead(node);
			return;
		}else{
			reverseNode(input, node.next);
			node.next.next	= node;
			node.next	= null;
		}
		
	}
}
