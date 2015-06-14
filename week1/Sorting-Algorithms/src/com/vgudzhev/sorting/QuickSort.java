package com.vgudzhev.sorting;

public class QuickSort implements Sortable {
	private int[] arr;

	@Override
	public int[] sort(int[] unsortedArray) {
		this.arr = unsortedArray;
		quicksort(arr, 0, unsortedArray.length - 1);

		return this.arr;
	}

	public void quicksort(int[] arr, int start, int end) {
		int index = partition(start, end);
		if (start < index-1) {
			quicksort(arr, start, index-1);
		}
		
		if (index < end) {
			quicksort(arr, index, end);
		}
	}

	private int partition(int start, int end) {
		int pivot = arr[start + (end-start) / 2];
		int i = start;
		int j = end;

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (pivot < arr[j]) {
				j--;
			}

			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		return i;
	}

	private void swap(int i, int j) {
		int value = arr[i];
		arr[i] = arr[j];
		arr[j] = value;
	}
}