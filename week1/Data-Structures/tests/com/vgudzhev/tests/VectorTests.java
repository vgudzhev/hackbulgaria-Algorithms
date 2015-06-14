package com.vgudzhev.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vgudzhev.ds.Vector;

public class VectorTests {
	private int RANDOM_VALUE = 123;

	@Test
	public void testShrink() {
		int SIZE = 11; // note that initial capacity is 10
		Vector<Integer> vector = new Vector<Integer>();
		for (int i = 0; i < SIZE; i++) {
			vector.add(i);
		}

		assertEquals(vector.size(), SIZE);
	}

	@Test
	public void insertAtValidPosition() {
		Vector<Integer> vector = new Vector<Integer>();
		vector.insert(0, 0);
		vector.insert(1, 1);
		vector.insert(2, 2);

		Integer firstTest = vector.get(0);
		Integer secondTest = vector.get(1);
		Integer thirdTest = vector.get(2);

		assertTrue(firstTest == 0);
		assertTrue(secondTest == 1);
		assertTrue(thirdTest == 2);
	}

	@Test
	public void insertAtIllegalPosition() {
		Vector<Integer> vector = new Vector<Integer>();
		boolean actual = false;
		try {
			vector.insert(100, 100);
		} catch (IndexOutOfBoundsException ex) {
			actual = true;
		}

		assertTrue(actual);
	}

	@Test
	public void insertAndShiftElements() {
		Vector<Integer> vector = new Vector<Integer>();
		// Inserting elements at the same index
		vector.insert(0, 0);
		vector.insert(0, 1);
		vector.insert(1, 2);

		int expectedValueAtZero = vector.get(0);
		int expectedValueAtOne = vector.get(1);
		assertEquals(vector.size(), 3);
		assertEquals(expectedValueAtZero, 1);
		assertEquals(expectedValueAtOne, 2);
	}

	@Test
	public void getElementValidPosition() {
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(123);
		Integer expected = vector.get(0);
		Integer actual = 123;

		assertEquals(expected, actual);
	}

	@Test
	public void getElementInvalidPosition() {
		Vector<Integer> vector = new Vector<Integer>();
		boolean actual = false;

		try {
			vector.get(0);
		} catch (IndexOutOfBoundsException e) {
			actual = true;
		}

		assertTrue(actual);
	}

	@Test
	public void removeElementAtValidPosition() {
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(RANDOM_VALUE);
		vector.add(RANDOM_VALUE);

		vector.remove(0);
		int expected = 1;
		int actual = vector.size();
		assertEquals(expected, actual);
	}

	@Test
	public void removeElementAtInvalidPosition() {
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(RANDOM_VALUE);
		vector.add(RANDOM_VALUE);
		boolean actual = false;

		try {
			vector.remove(3);
		} catch (IndexOutOfBoundsException e) {
			actual = true;
		}

		assertTrue(actual);
	}

	@Test
	public void removeElementAndShiftRest() {
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(1);
		vector.add(2);
		vector.add(3);

		vector.remove(1);

		int expected = vector.get(1);
		assertEquals(2, vector.size());
		assertEquals(expected, 3);

	}

	@Test
	public void popElement() {
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(RANDOM_VALUE);
		vector.add(RANDOM_VALUE);
		vector.pop();

		int actual = 1;
		int expected = vector.size();

		assertEquals(expected, actual);
	}

}
