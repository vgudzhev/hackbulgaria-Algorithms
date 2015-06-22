package com.vgudzhev.searching_algorithms.tasks;

import java.util.Arrays;

/**
 * Given four vectors of N integer values, compute how many quadruplets (one
 * element from every vector) form a total sum of zero.
 *
 */
public class Quadruples {
	
	// Returns the number of quadruplets that sum to zero.
	public static int zero_quadruplets_count(int[] a, int[] b, int[] c, int[] d) {
		int len = a.length;
		int[] left = new int[len * len];
		int[] right = new int[len * len];
		int counter = 0;
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				left[counter] = a[i] + b[j];
				right[counter] = c[i] + d[j];
				counter++;
			}
		}

		int result = 0;
		Arrays.sort(right);
		int searchedNumber;
		Pair pair;
		for (int i = 0; i < left.length; i++) {
			searchedNumber = 0 - left[i];
			pair = binarySearch(right, searchedNumber);
			if (pair.index >= 0) {
				result += pair.occurrence;
			}
		}
		return result;
	}
	
	private static class Pair{
		int index;
		int occurrence;
		public Pair(int i, int j){
			this.index =i;
			this.occurrence = j;
		}
	}
	
	// variation of binary search returns index of the first found value and
	// how many times ocurres in the array
	private static Pair binarySearch(int[] arr, int index){
		int left = 0;
		int right = arr.length-1;
		int middleElement;
		int occurenceCount =0;
		int middleIndex=-1;
		while (left<right) {
			middleIndex = left+ (right-left)/2;
			middleElement = arr[middleIndex];
			
			if (middleElement > index) {
				right = middleIndex;
			}else if (middleElement < index){
				left = middleIndex+1;
			}else{
				occurenceCount++;
				int leftFromIndex = middleIndex-1;
				int rightFromIndex = middleIndex+1;
				while (leftFromIndex >= 0 && arr[leftFromIndex] == index) {
						occurenceCount++;
						leftFromIndex--;
				}
				
				while(rightFromIndex < arr.length && arr[rightFromIndex] == index){
						occurenceCount++;
						rightFromIndex++;
				}
				break;
			}
		}
		if (occurenceCount == 0) {
			middleIndex = -1;
		}
		
		Pair pair = new Pair(middleIndex, occurenceCount);
		return pair;
	}
}