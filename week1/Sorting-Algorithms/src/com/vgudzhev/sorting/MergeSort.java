package com.vgudzhev.sorting;

public class MergeSort implements Sortable {
	private int[] arr;
	private int tempArray[];

	@Override
	public int[] sort(int[] unsortedArray) {
		this.arr = unsortedArray;
		this.tempArray = new int[arr.length];
		mergeSort(0, arr.length - 1);
		return arr;
	}

	private void mergeSort(int left, int right) {
		if (left < right) {
			int middle =left+  (right- left) / 2;
			mergeSort(left, middle);
			mergeSort(middle + 1, right);
			merge(left, middle, right);
		}
	}

	private void merge(int left, int middle, int right) {

	    for (int i = left; i <= right; i++) {
	      tempArray[i] = arr[i];
	    }

	    int leftIndex = left;
	    int rightIndex = middle + 1;
	    int index = left;
	    int leftEnd = middle;
	    int rightEnd = right;
	    
	    while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
	      if (tempArray[leftIndex] <= tempArray[rightIndex]) {
	        arr[index] = tempArray[leftIndex];
	        leftIndex++;
	      } else {
	        arr[index] = tempArray[rightIndex];
	        rightIndex++;
	      }
	      index++;
	    }
	    
	    // if leftIndex > leftEnd the elements are in right order
	    while (leftIndex <= leftEnd) {
	      arr[index] = tempArray[leftIndex];
	      index++;
	      leftIndex++;
	    }
	}
}
