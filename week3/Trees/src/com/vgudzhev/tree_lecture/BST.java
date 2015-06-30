package com.vgudzhev.tree_lecture;

public class BST {

	public static class Node {

		public int value;
		public Node left;
		public Node right;

		public void add(Node node) {

			if (this.value > node.value) {
				left = node;
				left.value = value;
			} else {
				right = node;
				right.value = value;
			}
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

		if (node.value <= minValue || node.value > maxValue) {
			return false;
		}

		return isValid(node.left, minValue, node.value)
				&& isValid(node.right, node.value, maxValue);
	}
}