package com.vgudzhev.heap_lecture.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.vgudzhev.heap_lecture.tasks.KMin;

public class KminTests {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(6);
		list.add(2);
		list.add(7);
		list.add(3);
		list.add(8);
		list.add(4);
		list.add(10);
		list.add(5);
		
		assertEquals(KMin.kthMinimum(list, 1), 1);
		assertEquals(KMin.kthMinimum(list, 2), 2);
		assertEquals(KMin.kthMinimum(list, 3), 3);
		assertEquals(KMin.kthMinimum(list, 4), 4);
	}

}
