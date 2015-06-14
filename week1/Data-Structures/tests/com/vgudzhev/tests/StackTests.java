package com.vgudzhev.tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.vgudzhev.ds.Stack;

public class StackTests {

	private static int RANDOM_INTEGER = 123;
	private static int OTHER_RANDOM_INTEGER = 666;

	@Test
	public void testPush() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(RANDOM_INTEGER);
		stack.push(OTHER_RANDOM_INTEGER);

		int actualSize = 2;
		int expectedSize = stack.size();
		int expectedValue = OTHER_RANDOM_INTEGER;
		int actualValue = stack.peek();

		assertEquals(expectedValue, actualValue);
		assertEquals(expectedSize, actualSize);
	}

	@Test
	public void testPopEmptyStack() {
		boolean actual = false;
		Stack<Integer> stack = new Stack<Integer>();
		try {
			stack.pop();
		} catch (NoSuchElementException e) {
			actual = true;
		}

		assertTrue(actual);
	}

	@Test
	public void testPop() {
		int expectedValue, actualValue, actualSize, expectedSize;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(RANDOM_INTEGER);
		stack.push(OTHER_RANDOM_INTEGER);

		expectedValue = OTHER_RANDOM_INTEGER;
		actualValue = stack.pop();
		actualSize = 1;
		expectedSize = stack.size();

		assertEquals(expectedValue, actualValue);
		assertEquals(expectedSize, actualSize);

		expectedValue = RANDOM_INTEGER;
		actualValue = stack.pop();

		assertEquals(expectedValue, actualValue);
		assertEquals(expectedSize, actualSize);
	}

	@Test
	public void testPeekEmptyStack() {
		boolean actual = false;
		Stack<Integer> Stack = new Stack<Integer>();
		try {
			Stack.peek();
		} catch (NoSuchElementException e) {
			actual = true;
		}

		assertTrue(actual);
	}

	@Test
	public void testPeek() {
		Stack<Integer> Stack = new Stack<Integer>();
		Stack.push(RANDOM_INTEGER);
		Stack.push(OTHER_RANDOM_INTEGER);

		int expectedValue = OTHER_RANDOM_INTEGER;
		int actualValue = Stack.peek();

		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testSize() {
		Stack<Integer> Stack = new Stack<Integer>();
		Stack.push(RANDOM_INTEGER);

		int actualSize = 1;
		int expectedSize = Stack.size();

		assertEquals(expectedSize, actualSize);
	}

	@Test
	public void testSizeMutpleElements() {
		Stack<Integer> Stack = new Stack<Integer>();
		for (int i = 0; i < OTHER_RANDOM_INTEGER; i++) {
			Stack.push(i);
		}

		int actual = OTHER_RANDOM_INTEGER;
		int expected = Stack.size();

		assertEquals(expected, actual);
	}

}
