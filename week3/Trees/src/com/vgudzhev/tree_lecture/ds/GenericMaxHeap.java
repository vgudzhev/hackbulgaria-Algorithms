package com.vgudzhev.tree_lecture.ds;

public class GenericMaxHeap<Pair extends Comparable<Pair>> {
	private final int MAX_ELEMEMTS = 1024;

	private Pair[] pair;
	private int size;

	public GenericMaxHeap() {
		this.pair = (Pair[]) new Comparable[MAX_ELEMEMTS];
		this.size = 0;
	}

	public void insert(Pair p) {
		pair[++size] = p;

		Pair lastAddedValue = pair[size];
		int index = this.size;
		while (hasParent(index)
				&& pair[getParentIndex(index)].compareTo(lastAddedValue) < 0) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public Pair popMax() {
		int index = 1;
		Pair value = pair[index];
		pair[index] = pair[size];
		pair[size--] = null;

		while (hasLeftChild(index)) {
			if (pair[index].compareTo(pair[getLeftChild(index)]) < 0) {
				swap(index, getLeftChild(index));
			} else {
				break;
			}
			index = getLeftChild(index);
		}

		return value;
	}

	public int getSize() {
		return this.size;
	}

	private void swap(int i, int j) {
		Pair temp = pair[i];
		pair[i] = pair[j];
		pair[j] = temp;
	}

	private int getLeftChild(int index) {
		return 2 * index;
	}

	private int getParentIndex(int index) {
		return (index / 2);
	}

	private boolean hasParent(int index) {
		return index > 1;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChild(index) <= size;
	}
}
