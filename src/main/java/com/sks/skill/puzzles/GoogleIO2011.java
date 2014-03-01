package com.sks.skill.puzzles;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.sks.skill.basic.Common;

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
		
		Common.createBreak();
		googleIO2011.gasketOld();
		
		Common.createBreak();
		googleIO2011.gasketNew();
		
		Common.createBreak();
		googleIO2011.gasketNewCorrect();
		
		Common.createBreak();
		googleIO2011.sizeMatters();
		
		Common.createBreak();
		googleIO2011.matchGame();
		
	}
	
	/**
	 *https://www.youtube.com/watch?v=wbp-3BJWsU8#t=697 
	 */
	private void matchGame() {
		System.out.println("Match Game Starting ");
		//Use at your own risk : sun wont last to see the o/p
		//Pattern pattern	= Pattern.compile("(aa|aab?)+"); 
		Pattern pattern	= Pattern.compile("(aab?)+");
		//Catastrophic back-tracking
		//2^n
		int count	= 0;
		for(String s = ""; s.length()<200; s+="a" ){
			if(pattern.matcher(s).matches()){
				count++;
			}
		}
		System.out.println("Match game  = "+count);
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
