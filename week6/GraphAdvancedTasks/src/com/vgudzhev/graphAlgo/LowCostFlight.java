package com.vgudzhev.graphAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Floyd–Warshall algorithm
public class LowCostFlight {
	public static void main(String[] args) {
		MyScanner scanner = new MyScanner();
		int N = scanner.nextInt();
		int[][] adjacencList = new int[N][N];

		int temp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp = scanner.nextInt();
				if (temp == 0) {
					temp = 1000000;
					adjacencList[i][j] = temp;
				} else {
					adjacencList[i][j] = temp;
				}
			}
		}

		Solver solver = new Solver(adjacencList, N);
		int M = scanner.nextInt();
		int start, destination;
		for (int i = 0; i <= M; i++) {
			start = scanner.nextInt();
			destination = scanner.nextInt();
			System.out.println(solver.solve(start, destination));
		}
	}

	public static class Solver {
		int[][] adjacencyList;
		int[][] distanceMatrix;
		int numberOfVertices;

		public Solver(int[][] adjacencyList, int numberOfVertices) {
			this.adjacencyList = adjacencyList;
			this.numberOfVertices = numberOfVertices;
			distanceMatrix = new int[numberOfVertices][numberOfVertices];
			init();
		}

		private void init() {
			for (int i = 0; i < numberOfVertices; i++) {
				for (int j = 0; j < numberOfVertices; j++) {
					distanceMatrix[i][j] = adjacencyList[i][j];
				}
			}

			for (int k = 0; k < numberOfVertices; k++) {
				for (int i = 0; i < numberOfVertices; i++) {
					for (int j = 0; j < numberOfVertices; j++) {
						if (distanceMatrix[i][j] > distanceMatrix[i][k]
								+ distanceMatrix[k][j]) {
							distanceMatrix[i][j] = distanceMatrix[i][k]
									+ distanceMatrix[k][j];
						}
					}
				}
			}
		}

		public String solve(int start, int destination) {
			int result = distanceMatrix[start][destination];
			if (result == 1000000) {
				return "NO WAY";
			}
			return result + "";
		}
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
