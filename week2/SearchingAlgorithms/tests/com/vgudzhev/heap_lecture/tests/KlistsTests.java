package com.vgudzhev.heap_lecture.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.vgudzhev.heap_lecture.tasks.KLists;

public class KlistsTests {

	@Test
	public void test() {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(10);
		list1.add(15);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(7);
		list3.add(8);
		list3.add(9);
		
		List<List<Integer>> wrapper = new ArrayList<List<Integer>>();
		wrapper.add(list1);
		wrapper.add(list2);
		wrapper.add(list3);
		List<Integer> mergedLists = KLists.merge(wrapper);
		
		boolean isMerged = true;
		for (int i = 0; i < mergedLists.size()-1; i++) {
			if (mergedLists.get(i) > mergedLists.get(i+1)) {
				isMerged = false;
				break;
			}
		}
		
		assertTrue(isMerged);
	}
}
