package com.me.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestList {
	
	private List testPeople = new List();
	
	@Before
	public void init() {
		testPeople.add("Gyula");
		testPeople.add("Gizi");
	}

	@Test
	public void testSize() {
		assertEquals("Mértel ellenőrzés", 2, testPeople.size());
	}
	
	@Test
	public void testIsEmpty() {
		assertFalse(testPeople.isEmpty());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void remove() {
		testPeople.remove("Norbi");
	}
	
	@After
	public void destroy() {
		testPeople.removeAll();
	}
}
