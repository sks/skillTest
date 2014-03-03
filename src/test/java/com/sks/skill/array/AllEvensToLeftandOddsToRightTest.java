package com.sks.skill.array;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Sabith_ks
 * Test cases for AllEvensToLeftandOddsToRight
 *
 */
public class AllEvensToLeftandOddsToRightTest {

	/**
	 * 
	 */
	@Test
	public void sortTest() {
		AllEvensToLeftandOddsToRight allEvensToLeftandOddsToRight = new AllEvensToLeftandOddsToRight();
		Integer[] output = allEvensToLeftandOddsToRight.sort(new Integer[]{1,2,3,4,5,6,7,8});
		assertArrayEquals(new Integer[]{8, 2, 6, 4, 5, 3, 7, 1}, output);
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void sortNullInput() {
		new AllEvensToLeftandOddsToRight().sort(null);
	}

}
