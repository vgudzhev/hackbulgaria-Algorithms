package com.vgudzhev.heap_lecture.tasks.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vgudzhev.heap_lecture.MinHeap;

public class MinHeapTests {

	@Test
	public void test() {
		MinHeap minHeap = new MinHeap();
		minHeap.insert(15);
		
		assertEquals(minHeap.getMin(), 15);
		
		minHeap.insert(20);
		minHeap.insert(5);
		
		assertEquals(minHeap.getMin(), 5);
		
		minHeap.insert(13);
		
		assertEquals(minHeap.popMin() , 5);
//		assertEquals(minHeap.popMin() , 13);
	}

}
