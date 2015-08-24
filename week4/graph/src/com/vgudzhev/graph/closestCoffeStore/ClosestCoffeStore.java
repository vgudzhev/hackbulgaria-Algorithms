package com.vgudzhev.graph.closestCoffeStore;


public class ClosestCoffeStore {

	public static void main(String[] args) {
		int[] row0 = { 0, 1, 0, 1, 0, 0 };
		int[] row1 = { 1, 0, 1, 0, 0, 0 };
		int[] row2 = { 0, 1, 0, 0, 1, 0 };
		int[] row3 = { 1, 0, 0, 0, 0, 0 };
		int[] row4 = { 0, 0, 1, 0, 0, 1 };
		int[] row5 = { 0, 0, 0, 0, 1, 0 };

		ClosestCoffeStoreImpl graph = new ClosestCoffeStoreImpl(6);
		graph.addRow(0, row0);
		graph.addRow(1, row1);
		graph.addRow(2, row2);
		graph.addRow(3, row3);
		graph.addRow(4, row4);
		graph.addRow(5, row5);
		
		System.out.println(graph.findClosestCoffeStore(0, new boolean[]{false,false,true,false,false,true}));
	}
}
