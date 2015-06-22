package com.vgudzhev.heap_lecture.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.vgudzhev.heap_lecture.tasks.HeapSort;

public class HeapSortTests {

	private int[] RANDOM_ARRAY;
	private int MAX_INTEGER = 50;
	private int ARRAY_SIZE = 5;

	@Before
	public void setUp() {
		Random randomGenerator = new Random();
		RANDOM_ARRAY = new int[ARRAY_SIZE];
		for (int i = 0; i < ARRAY_SIZE; i++) {
			RANDOM_ARRAY[i] = randomGenerator.nextInt(MAX_INTEGER);
		}
	}

	@Test
	public void testHeapSort() {
		HeapSort sorter = new HeapSort();
		int[] sortedArray = sorter.sort(RANDOM_ARRAY);
		boolean isSorted = isSorted(sortedArray);

		assertTrue(isSorted);
	}
	
	private boolean isSorted(int[] sortedArray) {
		for (int i = 1; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] > sortedArray[i + 1]) {
				return false;
			}
		}

		return true;
	}

}
