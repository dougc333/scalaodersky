package edu.stanford.codingbat;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWarmup1 {
	private static Warmup1 tw=new Warmup1();
	
	//sleepIn(false, false) → true
	//sleepIn(true, false) → false
	//sleepIn(false, true) → true  
	@Test
	public void testSleepIn(){
		assertEquals(true,tw.sleepIn(false, true));
		assertEquals(false,tw.sleepIn(true, false));
		assertEquals(true,tw.sleepIn(false, true));
	}
	
	//monkeyTrouble(true, true) → true
	//monkeyTrouble(false, false) → true
	//monkeyTrouble(true, false) → false
	@Test
	public void testMonkeyTrouble(){
		assertEquals(true,tw.monkeyTrouble(true, true));
		assertEquals(true,tw.monkeyTrouble(false, false));
		assertEquals(false,tw.monkeyTrouble(true, false));
	}
	
	//sumDouble(1, 2) → 3
	//sumDouble(3, 2) → 5
	//sumDouble(2, 2) → 8
	@Test
	public void testSumDouble(){
		assertEquals(3,tw.sumDouble(1, 2));
		assertEquals(5,tw.sumDouble(3, 2));
		assertEquals(8,tw.sumDouble(2, 2));
	}

	
}
