package com.vgudzhev.heap_lecture.tasks;

import com.vgudzhev.heap_lecture.MinHeap;

public class HeapSort {

	// Sorts a sequence of integers.
	public int[] sort(int[] sequence) {
		MinHeap minHeap = new MinHeap();
		for (int i = 0; i < sequence.length; i++) {
			minHeap.insert(sequence[i]);
		}

		int heapSize = minHeap.getSize();
		for (int i = 0; i < heapSize; i++) {
			sequence[i] = minHeap.popMin();
		}

		return sequence;
	}
}
