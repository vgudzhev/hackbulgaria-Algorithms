package com.vgudzhev.sorting;

public class CountSort implements Sortable {
	private int maxElement;
	private int[] arr;

	public CountSort(int maxElement) {
		this.maxElement = maxElement;
	}

	@Override
	public int[] sort(int[] unsortedArray) {
		arr = unsortedArray;

		int[] bucket = new int[maxElement + 1];
		int currentNumber;
		for (int i = 0; i < arr.length; i++) {
			currentNumber = arr[i];
			bucket[currentNumber]++;
		}

		int sortedELementsIndex = 0;
		for (int i = 0; i < bucket.length; i++) {
			while (bucket[i] > 0) {
				arr[sortedELementsIndex++] = i;
				bucket[i]--;
			}
		}

		return arr;
	}
}