package com.sks.skill.sorting.heapsort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sabith_ks
 *
 * @param <T>
 * Inspired by https://www.youtube.com/watch?v=W81Qzuz4qH0
 */
public class Heap<T extends Comparable<T>> {

	private List<T> internalItems;

	/**
	 * @param heapSize
	 */
	public Heap(){
		internalItems	= new ArrayList<T>();
	}

	private void siftUp(){
		int k = internalItems.size()-1;
		while(k>0){
			//get the parent of the k-th element
			int p = (k-1)/2;
			T parent	= internalItems.get(p);
			T item	= internalItems.get(k);
			if(item.compareTo(parent)>0){
				internalItems.set(p, item);
				internalItems.set(k, parent);
				k = p;
			}else{
				break;
			}
		}
	}

	private void siftDown(){
		int k = 0;
		int 	leftChild = 1, 
				rightChild, maxChild;
		T value;
		while(leftChild < internalItems.size()){
			rightChild = leftChild+1;
			maxChild 	= leftChild;
			//Check if there is a right child
			if(	rightChild  < internalItems.size() &&
					internalItems.get(rightChild).compareTo(internalItems.get(leftChild))>0){
				//right is greater than left
				maxChild	= rightChild;
			}

			if(internalItems.get(k).compareTo(internalItems.get(maxChild))>0){
				//Since the parent is bigger than the greatest of child, break
				break;
			}
			//The parent is smaller than the child : contradictory to max-heap property
			value	= internalItems.get(k);
			internalItems.set(k, internalItems.get(maxChild));
			internalItems.set(maxChild, value);
			k = maxChild;
			leftChild = 2*k+1;
		}
	}

	/**
	 * @param item
	 * adds to the heap and does the siftup
	 */
	public void add(T item){
		this.internalItems.add(item);
		siftUp();
	}

	/**
	 * @param items
	 * adds all the items and then does the siftup
	 */
	public void addAll(List<T> items){
		this.internalItems.addAll(items);
		siftUp();
	}

	/**
	 * @return remove the apex of the heap
	 */
	public T remove(){
		if(internalItems.size()==0){
			throw new ArrayIndexOutOfBoundsException();
		}
		if(internalItems.size()==1){
			return internalItems.remove(0);
		}
		T returnT	= this.internalItems.get(0);
		this.internalItems.set(0, internalItems.remove(internalItems.size()-1));
		siftDown();
		return returnT;
	}

	/**
	 * @return the size of the heap
	 */
	public int size() {
		return this.internalItems.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return this.internalItems.toString();
	}
	

}
