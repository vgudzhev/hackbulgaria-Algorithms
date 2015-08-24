package com.vgudzhev.graph.phoneNumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PhoneNumbersImpl {
	private List<Node> adjacencyList;
	private boolean[] visited;
	private int size;
	
	public PhoneNumbersImpl(int size){
		visited = new boolean[size];
		this.size = size;
		adjacencyList = new ArrayList<Node>();
	}
	
	private class Node{
		public List<Integer> neighbors = new ArrayList<Integer>();
		public int value;
		
		public Node(int v){
			this.value = v;
		}
	}
	
	public void addValues(int listID, int value){
		Node node = new Node(value);
		adjacencyList.add(listID, node);
		
	}
	
	public void addNeighbors(int listID, int neighbor){
		adjacencyList.get(listID).neighbors.add(neighbor);
	}
	
	private List<Integer> getNeighbors(int index){
		return adjacencyList.get(index).neighbors;
	}
	
	public int solve(){
		Queue<Integer> queue = new LinkedList<Integer>();
		int minNumberCalls = 0;
		
		for (int i = 0; i < size; i++) {
			if (visited[i]) {
				queue.add(i);
				
				while (!queue.isEmpty()) {
					int currentVertex = queue.poll();
					for (Integer n : getNeighbors(currentVertex)) {
						if (!visited[n]) {
							queue.add(n);
							visited[n] = true;
						}
					}
				}
			}else{
				minNumberCalls++;
				queue.add(i);
				visited[i]=true;
				
				while (!queue.isEmpty()) {
					int currentVertex = queue.poll();
					for (Integer n : getNeighbors(currentVertex)) {
						if (!visited[n]) {
							queue.add(n);
							visited[n] = true;
						}
					}
				}
				
			}
		}
		
		return minNumberCalls;
	}
}
