package com.vgudzhev.graph.closestCoffeStore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Represents the graph with adjacency matrix
public class ClosestCoffeStoreImpl {
	private boolean[][] adjacencyMatrix;
	private int SIZE;

	public ClosestCoffeStoreImpl(int val) {
		adjacencyMatrix = new boolean[val][val];
		this.SIZE = val;
	}

	public void addEdge(int edge, int vertex) {
		adjacencyMatrix[edge][vertex] = true;
	}
	
	public void addRow(int index, int[] arr){
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				addEdge(index, i);
			}
		}
	}

	public List<Integer> getListOfNeighbors(int val) {
		List<Integer> neighbors = new ArrayList<Integer>();
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[val][i]) {
				neighbors.add(i);
			}
		}

		return neighbors;
	}
	
	public int findClosestCoffeStore(int startPoint, boolean[] coffeeShops){
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[SIZE];
		int[] distanceTo = new int[SIZE];
		
		distanceTo[startPoint] = 0;
		visited[startPoint] = true;
		queue.add(startPoint);
		int closestPath = 0;
		
		while (!queue.isEmpty()) {
			int currentValue = queue.poll();
			for (int neighbor : getListOfNeighbors(currentValue)) {
				if (!visited[neighbor]) {
					distanceTo[neighbor] = distanceTo[currentValue]+1;
					
					if (isCoffeeShop(neighbor, coffeeShops)) {
						closestPath = distanceTo[neighbor];
						break;
					}
					
					queue.add(neighbor);
					visited[neighbor] = true;
				}
			}
		}
		
		return closestPath;
	}
	
	private boolean isCoffeeShop(int val, boolean[] coffeeShops){
		return coffeeShops[val];
	}
}