package com.sks.skill.puzzles;

import java.math.BigDecimal;

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

	public static void main(String[] args){
		GoogleIO2011 googleIO2011 = new GoogleIO2011();
		googleIO2011.gasketOld();
		googleIO2011.gasketNew();
		googleIO2011.gasketNewCorrect();
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
	 * 
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
