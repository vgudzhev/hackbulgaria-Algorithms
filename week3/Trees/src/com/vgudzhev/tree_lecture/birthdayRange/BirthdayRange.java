package com.vgudzhev.tree_lecture.birthdayRange;

import com.vgudzhev.tree_lecture.ds.BinaryIndexTree;

public class BirthdayRange {
	private BinaryIndexTree tree;
	
	public BirthdayRange() {
		this.tree = new BinaryIndexTree();
	}

	// adds people who are born on a specific day
	public void add(int day, int numberOfPeople) {
		tree.update(day, numberOfPeople);
	}

	// removes people who are born on a specific day
	public void remove(int day, int numberOfPeople) {
		tree.delete(day, numberOfPeople);
	}

	// returns the number of people born in a range
	public int count(int startDay, int endDay) {
		return tree.count(endDay) - tree.count(startDay);
	}
	
	public void buildTree(int[] arr){
		tree.buildTree(arr);
	}
	
	public static void main(String[] args){
		int[] arr = {5, 10, 6, 7, 3, 4, 5, 11, 21, 300, 15};
		BirthdayRange birthdayRange = new BirthdayRange();
		birthdayRange.buildTree(arr);
		System.out.println("Count 2,10 --> 7 == " + birthdayRange.count(2, 10));
		System.out.println("Count 10,265 --> 5 == " + birthdayRange.count(10, 365));
		birthdayRange.add(8, 3);
		System.out.println("Count 7,11 --> 6 == " + birthdayRange.count(7, 11));
		birthdayRange.remove(8, 2);
		System.out.println("Count 7,11 --> 4 == " + birthdayRange.count(7, 11));
		birthdayRange.add(18, 5);
		System.out.println("Count 10,20 --> 8 == " + birthdayRange.count(10, 20));
		birthdayRange.add(5, 1);
		System.out.println("Count 5,25 --> 15 == " + birthdayRange.count(5, 15));
		birthdayRange.remove(5, 10);
		System.out.println("Count 1,10 --> 6 == " + birthdayRange.count(1, 10));
		
	}
}
