package com.vgudzhev.tree_lecture.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vgudzhev.tree_lecture.phoneBook.PhoneBook;

public class PhoneBookTests {
/**
insert 1 Stanislav
insert 15 Rado
lookup Rado
\>15
insert 6 Ivan
lookup Ivan
\>6
insert 8 Ivan
lookup Ivan
\>8
lookup Pesho
\>NOT FOUND!
remove Ivan
lookup Ivan
\>NOT FOUND!
insert 23 Ani
insert 44 Pesho
insert 77 Eli
insert 83 Georgi
list
\>Ani 23
\>Eli 77
\>Georgi 83
\>Pesho 44
\>Rado 15
\>Stanislav 1
 */
	@Test
	public void test() {
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.insert(new PhoneBook.Contact(1, "Stanislav"));
		phoneBook.insert(new PhoneBook.Contact(15, "Rado"));
		
		assertEquals(phoneBook.lookup("Rado"), 15);
		
		phoneBook.insert(new PhoneBook.Contact(6, "Ivan"));
		phoneBook.insert(new PhoneBook.Contact(8, "Ivan"));
		
		assertEquals(phoneBook.lookup("Ivan"), 8);
		assertEquals(phoneBook.lookup("Pesho"), -1);
		
		phoneBook.remove("Ivan");
		
		assertEquals(phoneBook.lookup("Ivan"), -1);
		
		phoneBook.insert(new PhoneBook.Contact(23, "Ani"));
		phoneBook.insert(new PhoneBook.Contact(44, "Pesho"));
		phoneBook.insert(new PhoneBook.Contact(77, "Eli"));
		phoneBook.insert(new PhoneBook.Contact(83, "Georgi"));
		
		phoneBook.list();
		
	}

}
