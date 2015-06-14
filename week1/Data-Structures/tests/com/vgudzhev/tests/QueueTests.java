package com.vgudzhev.tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.vgudzhev.ds.Queue;

public class QueueTests {
	private static int RANDOM_INTEGER = 123;
	private static int OTHER_RANDOM_INTEGER = 666;

	@Test
	public void testPush() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.push(RANDOM_INTEGER);
		queue.push(RANDOM_INTEGER);

		int actualSize = 2;
		int expectedSize = queue.size();
		int expectedValue = RANDOM_INTEGER;
		int actualValue = queue.peek();

		assertEquals(expectedValue, actualValue);
		assertEquals(expectedSize, actualSize);
	}

	@Test
	public void testPopEmptyQueue() {
		boolean actual = false;
		Queue<Integer> queue = new Queue<Integer>();
		try {
			queue.pop();
		} catch (NoSuchElementException e) {
			actual = true;
		}

		assertTrue(actual);
	}

	@Test
	public void testPop() {
		int expectedValue, actualValue, actualSize, expectedSize;
		Queue<Integer> queue = new Queue<Integer>();
		queue.push(RANDOM_INTEGER);
		queue.push(OTHER_RANDOM_INTEGER);

		expectedValue = RANDOM_INTEGER;
		actualValue = queue.pop();
		actualSize = 1;
		expectedSize = queue.size();

		assertEquals(expectedValue, actualValue);
		assertEquals(expectedSize, actualSize);

		expectedValue = OTHER_RANDOM_INTEGER;
		actualValue = queue.pop();

		assertEquals(expectedValue, actualValue);
		assertEquals(expectedSize, actualSize);
	}

	@Test
	public void testPeekEmptyQueue() {
		boolean actual = false;
		Queue<Integer> queue = new Queue<Integer>();
		try {
			queue.peek();
		} catch (NoSuchElementException e) {
			actual = true;
		}

		assertTrue(actual);
	}

	@Test
	public void testPeek() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.push(RANDOM_INTEGER);
		queue.push(OTHER_RANDOM_INTEGER);

		int expectedValue = RANDOM_INTEGER;
		int actualValue = queue.peek();

		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testSize() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.push(RANDOM_INTEGER);

		int actualSize = 1;
		int expectedSize = queue.size();

		assertEquals(expectedSize, actualSize);
	}

	@Test
	public void testSizeMutpleElements() {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < OTHER_RANDOM_INTEGER; i++) {
			queue.push(i);
		}

		int actual = OTHER_RANDOM_INTEGER;
		int expected = queue.size();

		assertEquals(expected, actual);
	}
}
