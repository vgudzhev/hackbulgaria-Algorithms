package com.vgudzhev.ds.interfaces;

public interface VectorInterface<T> {

	/**
	 * Adds value at a specific index in the Vector. Complexity: O(n)
	 */
	void insert(int index, Object value);

	/**
	 * Adds value to the end of the Vector. Complexity: O(1)
	 */
	void add(Object value);

	/**
	 * Returns value at a specific index in the Vector Complexity: O(1)
	 */
	T get(int index);

	/**
	 * Removes element at the specific index Complexity: O(n)
	 */
	void remove(int index);

	/**
	 * Removes element at the last index Complexity: O(1)
	 */
	void pop();

	/**
	 * Returns the number of elements in the Vector. Complexity: O(1)
	 */
	int size();

	/**
	 * Returns the total capacity of the Vector. Complexity: O(1)
	 */
	int capacity();
}