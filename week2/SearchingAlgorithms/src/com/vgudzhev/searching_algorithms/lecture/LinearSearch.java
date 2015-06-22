package com.vgudzhev.searching_algorithms.lecture;

public class LinearSearch {
	public static int search(int[] arr, int searchedElement) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == searchedElement) {
				return i;
			}
		}
		return -1;
	}
}
