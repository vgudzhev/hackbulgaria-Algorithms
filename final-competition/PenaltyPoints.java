package com.vgudzhev.competition;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class PenaltyPoints {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System. in ));
		}

		public String next() {
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
	static class Node {
		int x;
		int y;
		int price;

		public Node(int x, int y, int price) {
			this.x = x;
			this.y = y;
			this.price = price;
		}

		@Override
		public String toString() {
			return x + ":" + y + "->" + price;
		}
	}
	static int N, M;
	static PriorityQueue < Node > availableVertex;
	static int[][] mountain;
	static int[][] dist;
	static boolean[][] visited;
	static int roadLength = 0;

	//update dist for each row col with new value
	static void findMinTime(int row, int col) {
		if (!visited[row][col]) {
			visited[row][col] = true;

			int currentValue = mountain[row][col];
			int currentDist = dist[row][col];


			if (isInBorder(row, col - 1)) {
				if (!visited[row][col - 1]) {
					int value = mountain[row][col - 1];
					if (value == -1) {
						visited[row][col - 1] = true;
					} else {
						int updated = value + currentDist;

						if (dist[row][col - 1] > updated) {
							dist[row][col - 1] = updated;
						}
						availableVertex.add(new Node(row, col - 1, updated));
					}
				}
			}

			if (isInBorder(row - 1, col)) {
				if (!visited[row - 1][col]) {
					int value = mountain[row - 1][col];
					if (value == -1) {
						visited[row - 1][col] = true;
					} else {
						int updated = value + currentDist;

						if (dist[row - 1][col] > updated) {
							dist[row - 1][col] = updated;
						}
						availableVertex.add(new Node(row - 1, col, updated));
					}
				}
			}
			if (isInBorder(row + 1, col)) {
				if (!visited[row + 1][col]) {
					int value = mountain[row + 1][col];
					if (value == -1) {
						visited[row + 1][col] = true;
					} else {
						int updated = value + currentDist;

						if (dist[row + 1][col] > updated) {
							dist[row + 1][col] = updated;
						}
						availableVertex.add(new Node(row + 1, col, updated));
					}
				}
			}

			if (isInBorder(row, col + 1)) {
				if (!visited[row][col + 1]) {
					int value = mountain[row][col + 1];
					if (value == -1) {
						visited[row][col + 1] = true;
					} else {
						int updated = value + currentDist;

						if (dist[row][col + 1] > updated) {
							dist[row][col + 1] = updated;
						}
						availableVertex.add(new Node(row, col + 1, updated));
					}
				}

			}
		}

		if (availableVertex.isEmpty()) {
			return;
		}

		Node next = availableVertex.poll();

		if (!visited[next.x][next.y]) {
			//   int price = dist[row][col] + next.price;
			//   if (dist[next.x][next.y] > price) {
			//    dist[next.x][next.y] = price;
			//    
			//    availableVertex.add(new Node(next.x, next.y, price));
			//   }

			findMinTime(next.x, next.y);
		} else {
			findMinTime(row, col);
		}
	}

	private static boolean isInBorder(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) {
			return false;
		} else {
			return true;
		}
	}


	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		availableVertex = new PriorityQueue < Node > (new Comparator < Node > () {@Override
			public int compare(Node p1, Node p2) {
				if (p1.price < p2.price) {
					return -1;
				} else {
					return 1;
				}

			}
		});

		N = sc.nextInt();
		M = sc.nextInt();
		int startRow = 0;
		int startCol = 0;
		int endRow = 0;
		int endCol = 0;

		visited = new boolean[N][M];
		mountain = new int[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] line = sc.nextLine().toCharArray();
			for (int j = 0; j < M; j++) {
				char ch = line[j];
				int value = 0;
				if (ch == 'S') {
					startRow = i;
					startCol = j;
				} else if (ch == '#') {
					value = -1;
				} else if (ch == 'E') {
					endRow = i;
					endCol = j;
				} else {
					value = ch - '0';
				}
				mountain[i][j] = value;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		dist[startRow][startCol] = 0;

		findMinTime(startRow, startCol);

		out.print(dist[endRow][endCol]);

		out.flush();
		out.close();
	}

}