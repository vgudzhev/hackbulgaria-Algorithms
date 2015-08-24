package com.vgudzhev.graph.phoneNumbers;

public class PhoneNumbers {
	public static void main(String[] args) {
		PhoneNumbersImpl graph = new PhoneNumbersImpl(6);
		graph.addValues(0, 0);
		graph.addValues(1, 1);
		graph.addValues(2, 2);
		graph.addValues(3, 3);
		graph.addValues(4, 4);
		graph.addValues(5, 5);
		
		graph.addNeighbors(0, 1);
		graph.addNeighbors(0, 2);
		
		graph.addNeighbors(1, 0);
		graph.addNeighbors(1, 2);
		
		graph.addNeighbors(2, 0);
		graph.addNeighbors(2, 1);
		
		graph.addNeighbors(3, 4);
		
		graph.addNeighbors(4, 3);
		
		System.out.println(graph.solve());
	}
}
