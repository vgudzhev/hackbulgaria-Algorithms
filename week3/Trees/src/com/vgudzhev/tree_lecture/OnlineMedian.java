package com.vgudzhev.tree_lecture;

import com.vgudzhev.tree_lecture.ds.MaxHeap;
import com.vgudzhev.tree_lecture.ds.MinHeap;

public class OnlineMedian {
	private int leftCount;
	private int rightCount;
	private int median;
	private MinHeap minHeap;
	private MaxHeap maxHeap;

	public OnlineMedian() {
		leftCount = 0;
		rightCount = 0;
		median = Integer.MIN_VALUE;
		minHeap = new MinHeap();
		maxHeap = new MaxHeap();
	}
	
	// inserts the number and returns the median
	public int insert(int number) {
		
		if (leftCount == 0 && rightCount == 0) {
			median = number;
			maxHeap.insert(number);
			leftCount++;
			return median;
		}
		
		if (number <= median) {
			maxHeap.insert(number);
			leftCount++;
		}
		
		if (number > median) {
			minHeap.insert(number);
			rightCount++;
		}
		
		if (leftCount > rightCount) {
			median = maxHeap.getMax();
		}
		
		if (leftCount <= rightCount) {
			median =  minHeap.getMin();
		}
		
		return median;
	}
}