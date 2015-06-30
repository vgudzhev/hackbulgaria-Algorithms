package com.vgudzhev.tree_lecture.ds;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
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
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	public void insert(Key key, Value val) {
		root = insert(root, key, val);
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	private Value get(Node node, Key key) {
		if (node == null) {
			return null;
		}

		if (key.compareTo(node.key) < 0) {
			return get(node.left, key);

		} else if (key.compareTo(node.key) > 0) {
			return get(node.right, key);

		} else {
			return node.value;
		}
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