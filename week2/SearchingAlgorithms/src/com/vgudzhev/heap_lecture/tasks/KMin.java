package com.vgudzhev.heap_lecture.tasks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vgudzhev.heap_lecture.MinHeap;

public class KMin {

	public static int kthMinimum(List<Integer> numbers, int k) {
		MinHeap heap = new MinHeap();
		Set<Integer> set = new HashSet<Integer>();

		for (Integer i : numbers) {
			set.add(i);
		}

		for (Integer integer : set) {
			heap.insert(integer);
		}

		int kthSmallest = -1;
		for (int i = 1; i <= k; i++) {
			if (i == k) {
				kthSmallest = heap.popMin();
			}
			heap.popMin();
		}
		return kthSmallest;
	}
}
