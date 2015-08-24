package com.vgudzhev.competition;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Stronghold {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static void main(String[] args) {
		MScanner scanner = new MScanner();

		int numWalls = scanner.nextInt();
		int[] wallHeight = new int[numWalls];
		BinarySearchTree < Integer, Integer > tree = new BinarySearchTree < Integer, Integer > ();

		for (int i = 1; i <= wallHeight.length; i++) {
			int currVal = scanner.nextInt();
			tree.insert(currVal, i);
		}

		int eventsNum = scanner.nextInt();
		String[] line;

		for (int i = 0; i < eventsNum; i++) {
			line = scanner.nextLine().split(" ");

			if (line[0].equals("shoot")) {

				int shootHeight = Integer.parseInt(line[1]);
				BinarySearchTree.Node node = tree.get(shootHeight);

				out.println(node == null ? "MISS" : node.value);
				if (node != null) {
					tree.delete((Integer) node.key);
				}


			} else if (line[0].equals("build")) {
				tree.insert(Integer.parseInt(line[2]),
				Integer.parseInt(line[1]));
			}
		}
		out.flush();
		out.close();
	}

	public static class BinarySearchTree < Key extends Comparable < Key > , Value > {
		private Node root;

		public class Node {
			public Key key;
			public Value value;
			public Node left;
			public Node right;

			public Node(Key key, Value value) {
				this.key = key;
				this.value = value;
			}

			@Override
			public String toString() {
				return "Key:" + key + " Value:" + value;
			}
		}

		public boolean contains(Key key) {
			return get(key) != null;
		}

		public Node get(Key key) {
			return get(root, key);
		}

		public void insert(Key key, Value val) {
			root = insert(root, key, val);
		}

		public void delete(Key key) {
			root = delete(root, key);
		}

		private Node get(Node node, Key key) {
			if (node == null) {
				return null;
			}

			if (node.key.compareTo(key) > 0) {
				if (node.left != null) {
					if (node.left.key.compareTo(key) > 0) {
						return new Node(node.left.key, node.left.value);
					}
				}
				return new Node(node.key, node.value);

			} else if (node.key.compareTo(key) < 0) {
				node = get(node.right, key);
			} else {
				node = get(node.right, key);
			}
			return node;
		}

		private Node insert(Node x, Key key, Value val) {
			if (x == null) {
				return new Node(key, val);
			}

			if (key.compareTo(x.key) < 0) {
				x.left = insert(x.left, key, val);

			} else if (key.compareTo(x.key) > 0) {
				x.right = insert(x.right, key, val);

			} else {
				x.value = val;
			}

			return x;
		}

		private Node deleteMinElement(Node x) {
			if (x.left == null) {
				return x.right;
			}

			x.left = deleteMinElement(x.left);

			return x;
		}

		private Node delete(Node node, Key key) {
			if (node == null) {
				return null;
			}

			int cmp = key.compareTo(node.key);

			if (cmp < 0) {
				node.left = delete(node.left, key);

			} else if (cmp > 0) {
				node.right = delete(node.right, key);
			} else {
				// zero or one child
				if (node.right == null) {
					return node.left;
				}

				// zero or one child
				if (node.left == null) {
					return node.right;
				}

				// left and right child
				// get leftmost child from the right subtree and swap values
				// recursively do the same for the leftmost children
				Node temp = node;
				node = getMinElement(temp.right);
				node.right = deleteMinElement(temp.right);
				node.left = temp.left;
			}

			return node;
		}

		// return the left most element in the tree
		public Node getMinElement(Node node) {
			if (node.left == null) {
				return node;

			} else {
				return getMinElement(node.left);
			}
		}

		public Node getRoot() {
			return root;
		}

	}

	public static class MScanner {
		BufferedReader br;
		StringTokenizer st;

		public MScanner() {
			br = new BufferedReader(new InputStreamReader(System. in ));
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