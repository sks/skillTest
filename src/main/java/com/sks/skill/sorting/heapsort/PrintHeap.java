package com.sks.skill.sorting.heapsort;

import java.util.Arrays;

public class PrintHeap {
	
	public static void main(String[] args){
		Heap<Integer> heap	= new Heap<Integer>();
		heap.addAll(Arrays.asList(new Integer[]{21,3,54,23,454,555,656,5,543,42,323,23,232}));
		new PrintHeap().print(heap);
	}

	private void print(Heap<Integer> heap) {
		//0->1, 1->2, 2-4, 3->8
		int steps	= 0;
		for(int index=0; index<heap.size();){
			String output	= ""; 
			steps	= ((Double )(Math.pow(2, index))).intValue();
			for(int step=0; step<steps; step++){
				if(index+step>heap.size()-1){
					break;
				}
				output+= heap.get(index+step)+"\t";
			}
			//Increment these many steps
			index	+= steps;
			System.out.println(output);
		}
	}

}
