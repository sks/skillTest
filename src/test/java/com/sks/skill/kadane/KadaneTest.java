package com.sks.skill.kadane;

import static org.junit.Assert.*;

import org.junit.Test;

public class KadaneTest {


	@Test
	public void testOutputWithoutNegative() {
		Kadane kadane	= new Kadane();
		int answer	= kadane.maxSumOfContinuousSubsequence(new Integer[]{-1, 2, 0, -32, -6, -7, -1}, false);
		assertEquals(2, answer);
	}
	
	
	@Test
	public void testOutputWithNegative() {
		Kadane kadane	= new Kadane();
		int answer	= kadane.maxSumOfContinuousSubsequence(new Integer[]{-1, 2, 0, -32, -6, -7, -1}, true);
		assertEquals("Expecting the output as 1", 1, answer);
	}
	
	
	@Test
	public void testNullInput() {
		Kadane kadane	= new Kadane();
		int answer	= kadane.maxSumOfContinuousSubsequence(null, true);
		assertEquals(0, answer);
	}
	
}
