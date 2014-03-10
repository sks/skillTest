package com.sks.skill.sorting;

import java.util.Random;

/**
 * @author Sabith_ks
 * 
 * Bubble sort :
 * 		
 *
 */
public class SortAlgorithms {
	
	private static Random random	= new Random();
	
	private int maxArraySize;

	private int[] array;

	/**
	 * @param maxArraySize
	 */
	public SortAlgorithms(int maxArraySize){
		this.maxArraySize	= maxArraySize;
		generateRandomArray();
	}
	
	/**
	 * populates the array with some random numbers
	 */
	private void generateRandomArray() {
		this.array	= new int[maxArraySize];
		//create a array of random numbers
		for(int index=0; index<maxArraySize; index++){
			this.array[index] = random.nextInt(maxArraySize);  
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args){
		//new SortAlgorithms(20).bubbleSort(true);
		//new SortAlgorithms(20).selectionSort(true);
		//new SortAlgorithms(20).selectionSort(false);
		//new SortAlgorithms(20).insertionSort(false);
		new SortAlgorithms(20).shellSort(false);
	}

	/**
	 * @param isAscending
	 */
	private void shellSort(boolean isAscending) {
		
	}

	/**
	 * @param isAscending
	 * i=  0 -> size
	 *   j=  i, toInsert	= array[i]
	 *    j -> 0;
	 *     if(array[j-1]> toInsert)
	 *       array[j] = array[j-1]
	 *       j--;
	 *   		
	 *  
	 */
	public void insertionSort(boolean isAscending) {
		printArray("@ starting , the array order ");
		for(int i=0 ; i< maxArraySize; i++){
			int j = i;
			int toInsert	= array[i];
			printArray("Before"+ i+" "+j);
			while((j > 0) && (toInsert < array[j-1])){
				//the value is greater.
				array[j]= array[j-1];
				j--;
			}
			array[j]	= toInsert;
			printArray("After"+ i+" "+j);
		}
		printArray("Final sorted array in "+ ((isAscending) ? "Ascending ": "Descending")+" order ");
		
	}

	/**
	 * @param isAscending
	 * i= 0-> size
	 *    j=  i-> size, swapIndex=i
	 *      if(j< swapindex)
	 *         swap(j, swapIndex)
	 *         
	 */
	public void selectionSort(boolean isAscending) {
		for(int i=0; i<maxArraySize; i++){
			int swapIndex	= i;
			//now start the second loop from 1->i
			for(int j=i; j<maxArraySize; j++){
				
				if((array[j]>array[swapIndex] && isAscending )||
					(array[j]<array[swapIndex] && ! isAscending )	){
					//printArray("Before "+(j)+" inner iterations");
					//We got the perfect number to be swapped
					swapIndex	= j;
					//printArray("After "+(j)+" inner iterations");
				}
			}
			swapValues(swapIndex, i);
			//printArray("After "+(maxArraySize-i)+" outer iterations");
		}
		printArray("Final sorted array in "+ ((isAscending) ? "Ascending ": "Descending")+" order ");
	}

	/**
	 * its all about bubble sort
	 * Start from the ending and then compare that index with the other numbers.
	 * the heavier numbers are gonna come up
	 * 	 i= size-> 0
	 *    j=  0-> i
	 *      if(j > j+1)
	 *         swap(j, j+1)
	 *         
	 */
	public void bubbleSort(boolean isAscending) {
		for(int i=maxArraySize-1; i>1; i--){
			//now start the second loop from 1->i
			for(int j=0; j<i; j++){
				
				if((array[j]>array[j+1] && isAscending )||
					(array[j]<array[j+1] && ! isAscending )	){
					//printArray("Before "+(j)+" inner iterations");
					//the right side is less than left, so swap
					swapValues(j, j+1);
					//printArray("After "+(j)+" inner iterations");
				}
			}
			//printArray("After "+(maxArraySize-i)+" outer iterations");
		}
		printArray("Final sorted array in "+ ((isAscending) ? "Ascending ": "Descending")+" order ");
	}

	/**
	 * @param from
	 * @param to
	 * swaps the value b/w from & to
	 */
	private void swapValues(int from, int to) {
		if(from!=to){
			//swap only if the index are different
			array[to] = array[from]+array[to] - (array[from]=array[to]);
		}
	}

	/**
	 * @param info 
	 * 
	 */
	private void printArray(String info) {
		StringBuilder builder	= new StringBuilder();
		builder.append(info).append(":\t");
		for(int index=0; index<maxArraySize; index++){
			builder.append(array[index]).append("->");
		}
		System.out.println(builder.toString());
		
	}

}
