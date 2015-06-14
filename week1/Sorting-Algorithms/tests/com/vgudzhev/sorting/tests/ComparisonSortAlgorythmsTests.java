package com.vgudzhev.sorting.tests;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import com.vgudzhev.sorting.InsertionSort;
import com.vgudzhev.sorting.MergeSort;
import com.vgudzhev.sorting.QuickSort;
import com.vgudzhev.sorting.SelectionSort;
import com.vgudzhev.sorting.Sortable;

public class ComparisonSortAlgorythmsTests {
	private int[] RANDOM_ARRAY;
	private int MAX_INTEGER = 50;
	private int ARRAY_SIZE = 7;
	private Sortable sorter;

	@Before
	public void setUp() {
		Random randomGenerator = new Random();
		RANDOM_ARRAY = new int[ARRAY_SIZE];
		for (int i = 0; i < ARRAY_SIZE; i++) {
			RANDOM_ARRAY[i] = randomGenerator.nextInt(MAX_INTEGER);
		}
	}

	@Test
	public void testInsertionSort() {
		sorter = new InsertionSort();
		int[] sortedArray = sorter.sort(RANDOM_ARRAY);
		boolean isSorted = isSorted(sortedArray);

		assertTrue(isSorted);
	}
	
	@Test
	public void testSelectionSort() {
		sorter = new SelectionSort();
		int[] sortedArray = sorter.sort(RANDOM_ARRAY);
		boolean isSorted = isSorted(sortedArray);
		assertTrue(isSorted);
	}

	@Test
	public void testMergeSort() {
		sorter = new MergeSort();
		int[] sortedArray = sorter.sort(RANDOM_ARRAY);
		boolean isSorted = isSorted(sortedArray);

		assertTrue(isSorted);
	}

	@Test
	public void testQuickSort() {
		sorter = new QuickSort();
		int[] sortedArray = sorter.sort(RANDOM_ARRAY);
		boolean isSorted = isSorted(sortedArray);

		assertTrue(isSorted);
	}

	private boolean isSorted(int[] sortedArray) {
		for (int i = 0; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] > sortedArray[i + 1]) {
				return false;
			}
		}

		return true;
	}
}