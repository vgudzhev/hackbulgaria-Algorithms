package com.vgudzhev.graph.buildScript;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BuildScripts {
	private static List<List<String>> adjacencyList;
	private static Map<String, Integer> map;
	private static String[] vertices;
	private static boolean[] visited;
	private static String target;

	private static Stack<String> sorted;

	public static String topologicalSort(String target) {
		sorted = new Stack<String>();

		visitDFS(target);

		StringBuilder sb = new StringBuilder();
		while (!sorted.isEmpty()) {
			sb.append(sorted.pop() + " ");
		}
		return sb.toString().trim();
	}

	public static boolean visitDFS(String vertex) {
		Stack<String> stack = new Stack<String>();
		boolean[] inPath = new boolean[vertices.length];

		stack.push(vertex);

		while (!stack.isEmpty()) {
			String x = stack.pop();
			sorted.push(x);
			inPath[map.get(x)] = true;

			List<String> neighbours = adjacencyList.get(map.get(x));
			for (int i = 0; i < neighbours.size(); ++i) {
				String neighbour = neighbours.get(i);

				if (!visited[map.get(neighbour)]) {
					stack.push(neighbour);
					visited[map.get(neighbour)] = true;
				}
			}

		}

		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int vertexCount = scanner.nextInt();

		adjacencyList = new ArrayList<List<String>>(vertexCount);
		map = new HashMap<String, Integer>(vertexCount);
		vertices = new String[vertexCount];
		visited = new boolean[vertexCount];

		for (int i = 0; i < vertexCount; ++i) {
			String temp = scanner.next();
			adjacencyList.add(new ArrayList<String>());
			map.put(temp, i);
			vertices[i] = temp;
			visited[i] = false;
		}

		target = scanner.next();

		for (int i = 0; i < vertexCount; ++i) {
			int N = scanner.nextInt();
			for (int j = 0; j < N; ++j) {
				adjacencyList.get(i).add(scanner.next());
			}
		}

		scanner.close();
		String sorted = topologicalSort(target);
		System.out.println(sorted);
	}
}