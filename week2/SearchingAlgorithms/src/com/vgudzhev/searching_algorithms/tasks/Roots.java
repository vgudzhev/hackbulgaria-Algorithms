package com.vgudzhev.searching_algorithms.tasks;

/**
 * Roots Write a function that computes the square root of a number with binary
 * search. Precision of the result should be 0.00001.
 */
// Note that a loop with 100 iterations will be close enough to the desired
// result
public class Roots {
	
	 // Finds the square root of a number using binary search.
	public static double squareRootIterative(double number) {
		double low = 0;
		double high = number - 1;
		double middle;
		double squared;
		double result = -1;
		int counter = 0;
		while (low < high) {
			middle = low + (high - low) / 2;
			squared = middle * middle;
			counter++;
			if (counter == 100) {
				result = middle;
				break;
			}

			if (squared > number) {
				high = middle;
			} else if (squared < number) {
				low = middle;
			} else {
				result = middle;
				break;
			}
		}

		return result;
	}
}