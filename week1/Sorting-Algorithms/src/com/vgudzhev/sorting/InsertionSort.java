package com.vgudzhev.sorting;

public class InsertionSort implements Sortable {
	private int[] arr;

	@Override
	public int[] sort(int[] unsortedArray) {
		arr = unsortedArray;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j-1]) {
					swap(j, j-1);
				}
			}
		}
		return unsortedArray;
	}

	private int[] swap(int i, int j) {
		int firstValue = arr[i];
		arr[i] = arr[j];
		arr[j] = firstValue;

		return arr;
	}
}