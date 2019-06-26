package com.me.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBicycle {

	Bicycle bike = null;
	
	@Before
	public void init() {
		bike = new Bicycle();
	}
	
	@Test
	public void TestSum() {
		assertEquals(3, bike.sum(1, 1, 1));
		assertEquals(1, bike.sum(1, -1, 1));
	}
	
}
