package com.vgudzhev.searching_algorithms.lecture.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.vgudzhev.searching_algorithms.lecture.BinarySearch;
import com.vgudzhev.searching_algorithms.lecture.LinearSearch;

public class BinarySearchTests {

	private int MAX_INTEGER = 100;
	private Random randomGenerator;
	private int ARRAY_SIZE;
	private int NUMBER_TEST_CASES= 100;
	
	@Before
	public void setUp(){
		randomGenerator = new Random();
		ARRAY_SIZE = randomGenerator.nextInt(MAX_INTEGER);
	}

	private int[] getRandomArray() {
		int[] RANDOM_ARRAY;
		randomGenerator = new Random();
		RANDOM_ARRAY = new int[ARRAY_SIZE];
		for (int i = 0; i < ARRAY_SIZE - 1; i++) {
			RANDOM_ARRAY[i] = Math.abs(randomGenerator.nextInt(MAX_INTEGER));
		}

		return RANDOM_ARRAY;
	}

	private int getRandomIndex(int maxValue) {
		randomGenerator = new Random();
		return Math.abs(randomGenerator.nextInt(maxValue));
	}

	@Test
	public void testBinarySearch() {
		int linearSearchResult;
		int binarySearchResult;
		int[] randomArray;
		int randomIndex;
		int searchedValue;
		boolean areEqual = false;
		
		for (int i = 0; i < NUMBER_TEST_CASES; i++) {
			randomArray = getRandomArray();
			Arrays.sort(randomArray);
			randomIndex = getRandomIndex(ARRAY_SIZE);
			searchedValue = randomArray[randomIndex];
			linearSearchResult = LinearSearch
					.search(randomArray, searchedValue);
			binarySearchResult = BinarySearch
					.search(randomArray, searchedValue);
			if (linearSearchResult == binarySearchResult) {
				areEqual = true;
			} else {
				areEqual = false;
				break;
			}
		}

		assertTrue(areEqual);
	}

	@Test
	public void testBinSearchReturnLeftIndexWithEqualValues() {
		int[] testArr = { 0, 1, 1, 1, 1, 1, 1, 2 };
		int expectedIndex = 1;
		int actualIndex = BinarySearch.search(testArr, 1);

		assertEquals(expectedIndex, actualIndex);
	}
}