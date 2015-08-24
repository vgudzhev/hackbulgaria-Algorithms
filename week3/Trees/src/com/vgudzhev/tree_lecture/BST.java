package com.vgudzhev.tree_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BST {
	
	public static void main(String[] args){
		MyScanner scanner = new MyScanner();
		int N = scanner.nextInt();
		int[] arr= new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		Node tree = buildTree(arr);
		System.out.println(isBST(tree) == true ? "YES" : "NO");
	}
	
	public static Node buildTree(int[] values){
		Queue<Node> queue = new LinkedList<BST.Node>();
		Node root = new Node(values[0]);
		queue.add(root);
		int index = 1;
		int size = values.length;
		int currentValue;
		
		while (index < size) {
			Node current = queue.poll();
			currentValue = values[index];
		
			current.left = new Node(values[index]);
			queue.add(current.left);
			index++;
			
			
			if (index < size) {
				currentValue = values[index];
				
				current.right = new Node(values[index]);
				queue.add(current.right);
	
				index++;	
			}
		}
		
		return root;
	}
	

	public static class Node {

		public int value;
		public Node left;
		public Node right;
		
		public Node(int val){
			this.value = val;
		}
		
		@Override
		public String toString(){
			return value+"";
		}
	}

	// Checks if a binary tree is a binary search tree.
	public static boolean isBST(Node root) {
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isValid(Node node, int minValue, int maxValue) {

		if (node == null) {
			return true;
		}

		if (node.value != 0 && (node.value <= minValue || node.value > maxValue)) {
			return false;
		}

		return isValid(node.left, minValue, node.value)
				&& isValid(node.right, node.value, maxValue);
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

	   public String nextLine(){
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