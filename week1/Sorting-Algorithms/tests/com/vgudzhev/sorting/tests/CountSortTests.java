package com.vgudzhev.sorting.tests;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import com.vgudzhev.sorting.CountSort;

public class CountSortTests {
	private int MAX_ELEMENT = 10;
	private int ARRAY_SIZE = 20;
	private int[] randomArray;

	@Before
	public void setUp() {
		Random randomGenerator = new Random();
		randomArray = new int[ARRAY_SIZE];
		for (int i = 0; i < ARRAY_SIZE; i++) {
			randomArray[i] = randomGenerator.nextInt(MAX_ELEMENT + 1);
		}
	}

	@Test
	public void testCountSort() {
		CountSort sorter = new CountSort(MAX_ELEMENT);
		int[] expectedSortedArray = sorter.sort(randomArray);

		boolean isSorted;
		for (int i = 0; i < expectedSortedArray.length - 1; i++) {
			if (expectedSortedArray[i] > expectedSortedArray[i + 1]) {
				isSorted = false;
			}
		}

		isSorted = true;
		assertTrue(isSorted);
	}
}
