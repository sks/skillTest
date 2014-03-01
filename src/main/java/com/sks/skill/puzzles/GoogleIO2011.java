package com.sks.skill.puzzles;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sabith_ks
 * inspired by https://www.youtube.com/watch?v=wbp-3BJWsU8
 * 
 * Avoid floating double using where exact value is required
 * Use new BigDecimal(String)
 * BigDecimal.valueOf(Double);
 *
 */
public class GoogleIO2011 {
	
	enum Sex{Male, Female};

	public static void main(String[] args){
		GoogleIO2011 googleIO2011 = new GoogleIO2011();
		
		googleIO2011.gasketOld();
		
		googleIO2011.gasketNew();
		
		googleIO2011.gasketNewCorrect();
		
		googleIO2011.sizeMatters();
	}

	/**
	 * https://www.youtube.com/watch?v=wbp-3BJWsU8#t=697
	 */
	private void sizeMatters() {
		System.out.println(size(new HashMap<Sex, Sex>())+"");
		System.out.println(size(new EnumMap<Sex, Sex>(Sex.class))+"");
		//Not seen in 1.8 atleast :|
	}
	
	/**
	 * @param map
	 * @return
	 */
	private static int size(Map<Sex, Sex> map){
		map.put(Sex.Male, Sex.Female);
		map.put(Sex.Female, Sex.Male);
		map.put(Sex.Male, Sex.Male);
		map.put(Sex.Female, Sex.Female);
		Set<Map.Entry<Sex, Sex>> set	= new HashSet<Map.Entry<Sex, Sex>>(map.entrySet());
		return set.size();
	}

	/**
	 * https://www.youtube.com/watch?v=wbp-3BJWsU8#t=473
	 * Avoid floating double using where exact value is required
	 */
	private void gasketNewCorrect() {
		BigDecimal payment	= new BigDecimal("2.00");
		BigDecimal cost	= new BigDecimal("1.1");
		System.out.println("Gasket new Correct : "+payment.subtract(cost));
		
	}

	/**
	 * https://www.youtube.com/watch?v=wbp-3BJWsU8#t=247
	 */
	private void gasketNew() {
		//wrong bigdecimal constructer
		BigDecimal payment	= new BigDecimal(2.00);
		BigDecimal cost	= new BigDecimal(1.1);
		System.out.println("Gasket new Wrong : "+payment.subtract(cost));
		//Canonical representation 
		//Answer is 0.899999999999999911182158029987476766109466552734375
	}

	/**
	 * https://www.youtube.com/watch?v=wbp-3BJWsU8#t=190
	 */
	private void gasketOld() {
		System.out.println("Gasket Old "+ (2.00-1.1));
		//yeah the answer is .89999999999 : Not good
		
	}
}
