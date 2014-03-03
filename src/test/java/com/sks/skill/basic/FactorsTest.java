/**
 * 
 */
package com.sks.skill.basic;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

/**
 * @author Sabith_ks
 *
 */
public class FactorsTest {

	/**
	 * Test method for {@link com.sks.skill.basic.Factors#getFactors(int)}.
	 */
	@Test
	public void testGetFactors() {
		List<Integer> answer = new Factors().getFactors(4);
		assertThat(answer, IsIterableContainingInOrder.contains(1, 4, -1, -4, 2, -2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetFactorsForZero() {
		new Factors().getFactors(0);
	}

	/**
	 * Test method for {@link com.sks.skill.basic.Factors#getPrimeFactor(int)}.
	 */
	@Test
	public void testGetPrimeFactor() {
		List<Integer> answer = new Factors().getPrimeFactor(4);
		assertThat(answer, IsIterableContainingInOrder.contains(2, 2));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetPrimeFactorForZero() {
		new Factors().getPrimeFactor(0);
	}

}
