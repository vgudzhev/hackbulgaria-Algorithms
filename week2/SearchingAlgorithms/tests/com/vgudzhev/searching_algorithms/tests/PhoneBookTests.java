package com.vgudzhev.searching_algorithms.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.vgudzhev.searching_algorithms.tasks.PhoneBook;

public class PhoneBookTests {

	@Test
	public void test() {
		List<PhoneBook.Contact> phonebook = new ArrayList<PhoneBook.Contact>();
		phonebook.add(new  PhoneBook.Contact(1, "Stanislav"));
		phonebook.add(new  PhoneBook.Contact(15, "Rado"));
		phonebook.add(new  PhoneBook.Contact(6, "Ivan"));
		phonebook.add(new  PhoneBook.Contact(8, "Ivan"));
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(15);
		numbers.add(8);
		List<String> result = PhoneBook.lookupNames(phonebook, numbers);
		
		assertEquals(result.get(0), "Rado");
		assertEquals(result.get(1), "Ivan");
	}
}
