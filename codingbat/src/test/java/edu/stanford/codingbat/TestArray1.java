package edu.stanford.codingbat;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArray1 {
	Array1 a = new Array1();
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testFirstLast6(){
		int[] nums = {1,2,6};
		assertEquals(true,a.firstLast6(nums));
	}
}
