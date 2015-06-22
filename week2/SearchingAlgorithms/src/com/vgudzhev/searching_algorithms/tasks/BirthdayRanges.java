package com.vgudzhev.searching_algorithms.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a vector of people's birthdays (numbers in the range 0-365) and a
 * vector of ranges (pairs of numbers in the range 0-365) produce a vector of
 * the number of people with birthday in the specific range.
 */
public class BirthdayRanges {

	// Returns a vector with the number of people born in the specific ranges.
	public static List<Integer> birthdaysCount(List<Integer> birthdays,
			List<Pair> ranges) {
		int[] birthdayBucket = new int[365];
		for (int i = 0; i < birthdays.size(); i++) {
			birthdayBucket[birthdays.get(i)]++;
		}

		List<Integer> peopleBornInRangeCounter = new ArrayList<Integer>();
		int currentNumber = 0;
		Pair currentPair;
		for (int i = 0; i < ranges.size(); i++) {
			currentPair = ranges.get(i);
			currentNumber = countBirthdays(birthdayBucket, currentPair);
			peopleBornInRangeCounter.add(currentNumber);
		}

		return peopleBornInRangeCounter;
	}

	private static int countBirthdays(int[] birthdayBucket, Pair pair) {
		int birthdayCounter = 0;
		int start = pair.start;
		int end = pair.end;
		for (int i = start; i <= end; i++) {
			birthdayCounter += birthdayBucket[i];
		}

		return birthdayCounter;
	}

	public static class Pair {
		public int start;
		public int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
