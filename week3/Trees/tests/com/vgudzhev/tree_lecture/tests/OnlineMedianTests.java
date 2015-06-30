package com.vgudzhev.tree_lecture.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vgudzhev.tree_lecture.OnlineMedian;

public class OnlineMedianTests {

	@Test
	public void test() {
		OnlineMedian onlineMedian = new OnlineMedian();
		
		assertEquals(onlineMedian.insert(5), 5);
		assertEquals(onlineMedian.insert(6), 6);
		assertEquals(onlineMedian.insert(7), 6);
		assertEquals(onlineMedian.insert(4), 6);
		assertEquals(onlineMedian.insert(3), 5);
		assertEquals(onlineMedian.insert(10), 6);
		assertEquals(onlineMedian.insert(20), 7);	
	}
}
