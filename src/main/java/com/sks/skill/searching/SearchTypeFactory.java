package com.sks.skill.searching;

public class SearchTypeFactory {

	public static SearchMechanism getInstance(SearchType searchType) {
		switch(searchType){
		case LINEAR:
			return new LinearSearch();
		case BINARY:
			return new BinarySearch();
		default:
			return null;
		}
		
	}

}
