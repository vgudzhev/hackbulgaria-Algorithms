package com.vgudzhev.heap_lecture.tasks;

import java.util.ArrayList;
import java.util.List;

public class KLists {

	// Merge K sorted lists.
	public static List<Integer> merge(List<List<Integer>> lists) {
		MinHeap<Pair> heap = new MinHeap<Pair>();
		List<Integer> mergedList = new ArrayList<Integer>();

		// populate initial heap values
		for (int i = 0; i < lists.size(); i++) {
			heap.insert(new Pair(lists.get(i).get(0), 0, i));
		}

		Pair pair;
		int listID;
		int listIndex;
		while (heap.size > 0) {
			pair = (Pair) heap.popMin();
			listID = pair.listID;
			listIndex = pair.index;
			mergedList.add(lists.get(listID).get(listIndex));
			listIndex++;

			if (listIndex < lists.get(listID).size()) {
				heap.insert(new Pair(lists.get(listID).get(listIndex),
						listIndex, listID));
			}
		}

		return mergedList;
	}

	public static class Pair implements Comparable<Pair> {
		public int value;
		public int index;
		public int listID;

		public Pair(int value, int index, int listID) {
			this.value = value;
			this.index = index;
			this.listID = listID;
		}

		@Override
		public String toString() {
			return value + " ";
		}

		@Override
		public int compareTo(Pair p) {
			return Integer.compare(this.value, p.value);
		}
	}

	private static class MinHeap<Pair extends Comparable<Pair>> {
		private final int MAX_ELEMEMTS = 4;

		private Pair[] pair;
		private int size;

		public MinHeap() {
			this.pair = (Pair[]) new Comparable[MAX_ELEMEMTS];
			this.size = 0;
		}

		public void insert(Pair p) {
			pair[++size] = p;

			Pair lastAddedValue = pair[size];
			int index = this.size;
			while (hasParent(index)
					&& pair[getParentIndex(index)].compareTo(lastAddedValue) > 0) {
				swap(getParentIndex(index), index);
				index = getParentIndex(index);
			}
		}

		public Pair popMin() {
			int index = 1;
			Pair value = pair[index];
			pair[index] = pair[size];
			pair[size--] = null;

			while (hasLeftChild(index)) {
				if (pair[index].compareTo(pair[getLeftChild(index)]) > 0) {
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
}