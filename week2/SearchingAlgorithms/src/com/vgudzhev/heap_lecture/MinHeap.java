package com.vgudzhev.heap_lecture;

public class MinHeap {
	private final int MAX_ELEMEMTS = 1024;

	private int[] values;
	private int size;

	public MinHeap() {
		this.values = new int[MAX_ELEMEMTS];
		this.size = 0;
	}

	public void insert(int value) {
		values[++size] = value;
		int lastAddedValue = values[size];
		int index = this.size;
		while (hasParent(index)
				&& values[getParentIndex(index)] > lastAddedValue) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public int getMin() {
		return values[1];
	}

	public int popMin() {
		int index = 1;
		int value = values[index];
		values[index] = values[size];
		values[size--] = 0;

		while (hasLeftChild(index)) {
			if (values[index] > values[getLeftChild(index)]) {
				if (hasRightChild(index)
						&& values[getLeftChild(index)] > values[getRightChild(index)]) {
					swap(index, getRightChild(index));
				} else {
					swap(index, getLeftChild(index));
				}
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
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

	private int getLeftChild(int index) {
		return 2 * index;
	}

	private int getRightChild(int index) {
		return (2 * index) + 1;
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

	private boolean hasRightChild(int index) {
		return getRightChild(index) <= size;
	}
}