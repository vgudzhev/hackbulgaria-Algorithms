package com.vgudzhev.searching_algorithms.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vgudzhev.searching_algorithms.tasks.Quadruples;

public class QuadrupletsTests {

	@Test
	public void test() {
		int[] a = new int[] { 5, 3, 4 };
		int[] b = new int[] { -2, -1, 6 };
		int[] c = new int[] { -1, -2, 4 };
		int[] d = new int[] {-1, -2, 7 };
		
		int expected = 7;
		int actual = Quadruples.zero_quadruplets_count(a, b, c, d);
		
		assertEquals(expected, actual);
	}
}
