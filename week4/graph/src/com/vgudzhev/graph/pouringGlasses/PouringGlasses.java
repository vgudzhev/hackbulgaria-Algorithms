package com.vgudzhev.graph.pouringGlasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PouringGlasses {
	public static void main(String[] args){
		int[] amountOfWater = new int[3];
		int[] capacity = new int[3];
		int goal;
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			amountOfWater[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < 3; i++) {
			capacity[i] = scanner.nextInt();
		}
		
		goal = scanner.nextInt();
		
		System.out.println(solve(amountOfWater, capacity, goal));
		
	}

	private static int solve(int[] amountOfWater, int[] capacity, int goal) {
		
		return 1;
	}
	
	public static void buildGraph(int[] amountOfWater, int[] capacity){
		List<String> adjacecnyList = new ArrayList<String>();
		Map<String, String> path = new HashMap<String, String>();
		Map<String, String> edges = new HashMap<String, String>();
		
	}
}
