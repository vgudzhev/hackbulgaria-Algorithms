package com.vgudzhev.tree_lecture.phoneBook;

import com.vgudzhev.tree_lecture.ds.BinarySearchTree;
import com.vgudzhev.tree_lecture.phoneBook.PhoneBook.Contact;

public class PhoneBookStructure extends BinarySearchTree<Contact, Integer> {
	private Contact contact;

	public PhoneBookStructure() {
		contact = new Contact();
	}

	// inserts a new contact
	public void insert(Contact contact) {
		insert(contact, contact.number);
	}

	// lookup a name and print its phone number
	public int lookup(String name) {
		contact.name = name;
		Integer number = get(contact);
		if (number == null) {
			System.out.println("NOT FOUND!");
			return -1;

		} else {
			System.out.println(number);
			return number;
		}
	}

	// list all records in an alphabetical order
	public void list() {
		inOrder(super.getRoot());
	}

	private void inOrder(BinarySearchTree<Contact, Integer>.Node root) {
		if (root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.println(root.key.name + ":" + root.value);
		inOrder(root.right);
		
	}

	// remove a record for a given name
	public void remove(String name) {
		contact.name = name;

		delete(contact);
	}
}
