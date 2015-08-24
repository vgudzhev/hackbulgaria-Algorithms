package com.vgudzhev.minSpanningTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.vgudzhev.minSpanningTree.util.MyScanner;

public class PowerSupply {
	static class Pair{
		public int vertex;
		public int weight;
		
		public Pair(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
		
		public static Pair getInstance(int vertex, int weight){
			return new Pair(vertex, weight);
		}

		@Override
		public String toString(){
			return vertex + " " + weight;
		}
	}
	
	public static void main(String[] args){
		MyScanner scanner = new MyScanner();
		int N = scanner.nextInt();
		HashMap<Integer, ArrayList<Pair>> adjacencyList = new HashMap<Integer, ArrayList<Pair>>();
		
		int a,b,c;
		int firstIndex =1;
		for (int i = 0; i < N; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			firstIndex = a;
			
			if (!adjacencyList.containsKey(a)) {
	            adjacencyList.put(a, new ArrayList<Pair>());
	        }
	        	adjacencyList.get(a).add(Pair.getInstance(b, c));
			
			if (!adjacencyList.containsKey(b)) {
	            adjacencyList.put(b, new ArrayList<Pair>());
	        }
				adjacencyList.get(b).add(Pair.getInstance(a, c));

		}
		PowerSupply powerSupply = new PowerSupply();
		System.out.println(powerSupply.solve(adjacencyList,firstIndex));
	}
	
	
	
	private int solve(HashMap<Integer, ArrayList<Pair>> graph, int firstVertex) {
		int sum=0;
		int index = firstVertex;
		
		PriorityQueue<Pair> q = new PriorityQueue<Pair>(graph.size(),new Comparator<Pair>() {
            @Override
            public int compare(Pair arg0, Pair arg1) {
                return Integer.compare(arg0.weight, arg1.weight);
            }
        });
		
		for (Pair pair : graph.get(firstVertex)) {
			q.add(pair);
		}
		
		boolean[] visited = new boolean[graph.size()+1];
		visited[index] = true;
		
		while (!(q.isEmpty())) {
			Pair lowWeightPair = q.poll();
			
			if (!visited[lowWeightPair.vertex]) {
				sum+=lowWeightPair.weight;
				visited[lowWeightPair.vertex] = true;
				
				for (Pair p : graph.get(lowWeightPair.vertex)) {
					q.add(p);
				}
			}
		}

		return sum;
	}


	private static ArrayList<Pair> getNeighbors(HashMap<Integer,ArrayList<Pair>> vertices, int index) {
		ArrayList<Pair> currentPairs = new ArrayList<Pair>();
		
		for (Pair pair : vertices.get(index)) {
			currentPairs.add(pair);
		}
		
		return currentPairs;
	}
}