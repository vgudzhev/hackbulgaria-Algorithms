package com.vgudzhev.searching_algorithms.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {

	public static class Contact implements Comparable<Contact> {
		public int number;
		public String name;

		public Contact(int number, String name) {
			this.number = number;
			this.name = name;
		}

		@Override
		public int compareTo(Contact o) {
			if (this.number < o.number) {
				return -1;
			} else if (this.number > o.number) {
				return 1;
			}

			return 0;
		}
	}

	// Find the names of people based on their phone numbers.
	public static List<String> lookupNames(List<Contact> phoneBook,
			List<Integer> numbers) {
		List<String> result = new ArrayList<String>();
		Collections.sort(phoneBook);
		int currentIndex;
		int elementIndex;
		for (int i = 0; i < numbers.size(); i++) {
			currentIndex = numbers.get(i);
			Contact c = new Contact(currentIndex, null);
			elementIndex = Collections.binarySearch(phoneBook, c, null);
			if (elementIndex >= 0) {
				result.add(phoneBook.get(elementIndex).name);
			}
		}

		return result;
	}
}