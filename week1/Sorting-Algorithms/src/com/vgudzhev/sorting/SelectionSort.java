package com.vgudzhev.sorting;

public class SelectionSort implements Sortable {

	@Override
	public int[] sort(int[] unsortedArray) {
		int minValue;;
		for (int i = 0; i < unsortedArray.length - 1; i++) {
			minValue = unsortedArray[i];
			for (int j = i + 1; j < unsortedArray.length; j++) {
				if (unsortedArray[i] > unsortedArray[j]) {
					swap(unsortedArray, i, j);
				}
			}
		}

		return unsortedArray;
	}

	private int[] swap(int arr[], int i, int j) {
		int firstValue = arr[i];
		arr[i] = arr[j];
		arr[j] = firstValue;

		return arr;
	}
}