package com.vgudzhev.searching_algorithms.lecture;

public class BinarySearch {
	public static int search(int[] arr, int searchedValue) {
		return binarySearch(arr, 0, arr.length, searchedValue);
	}

	private static int binarySearch(int[] arr, int leftIndex, int rightIndex,
			int searchedValue) {
		int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
		int middleElement = arr[middleIndex];

		if (middleElement < searchedValue) {
			return binarySearch(arr, middleIndex + 1, rightIndex, searchedValue);
		} else if (middleElement > searchedValue) {
			return binarySearch(arr, leftIndex, middleIndex, searchedValue);
		} else {
			// this case checks if the middle index is equal to the searched element
			// but we are searching for the most left index of occurrence 
			if (middleElement < searchedValue) {
				return binarySearch(arr, middleIndex + 1, rightIndex,
						searchedValue);
			} else if (middleElement == searchedValue) {
				if (leftIndex == rightIndex) {
					return leftIndex;
				} else {
					return binarySearch(arr, leftIndex, middleIndex,
							searchedValue);
				}
			} else {
				return -1;
			}
		}
	}
}
