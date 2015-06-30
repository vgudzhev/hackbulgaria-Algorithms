package com.vgudzhev.tree_lecture.phoneBook;


public class PhoneBook {
	private PhoneBookStructure tree = new PhoneBookStructure();
	
	public static class Contact implements Comparable<Contact> {
		public int number;
		public String name;
		
		public Contact(int number, String name) {
			this.name = name;
			this.number = number;
		}

		public Contact() {}

		@Override
		public int compareTo(Contact contact) {
			return contact.name.compareTo(name);
		}
	}

	// inserts a new contact
	public void insert(Contact contact) {
		tree.insert(contact);
	}

	// lookup a name and print its phone number
	public int lookup(String name) {
		return tree.lookup(name);
	}

	// list all records in an alphabetical order
	public void list() {
		tree.list();
	}

	// remove a record for a given name
	public void remove(String name) {
		tree.remove(name);
	}
}
