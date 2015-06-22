package com.vgudzhev.searching_algorithms.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vgudzhev.searching_algorithms.tasks.Roots;

public class SquareRootTests {

	@Test
	public void testExactSquareRoot() {
		double sqrt4 = 2;
		double sqrt9 = 3;
		double sqrt16 = 4;
		double sqrt25 = 5;
		double sqrt36 = 6;

		double expectedSqrt4 = Roots.squareRootIterative(4);
		double expectedSqrt9 = Roots.squareRootIterative(9);
		double expectedSqrt16 = Roots.squareRootIterative(16);
		double expectedSqrt25 = Roots.squareRootIterative(25);
		double expectedSqrt36 = Roots.squareRootIterative(36);

		assertEquals(expectedSqrt4, sqrt4, 0.1);
		assertEquals(expectedSqrt9, sqrt9, 0.1);
		assertEquals(expectedSqrt16, sqrt16, 0.1);
		assertEquals(expectedSqrt25, sqrt25, 0.1);
		assertEquals(expectedSqrt36, sqrt36, 0.1);
	}

	@Test
	public void testSquareRoot() {
		double sqrt10 = Math.sqrt(10);
		double sqrt101 = Math.sqrt(101);
		double sqrt1043 = Math.sqrt(1043);
		double sqrt12345 = Math.sqrt(12345);
		double sqrt123456 = Math.sqrt(123456);

		double expectedSqrt10 = Roots.squareRootIterative(10);
		double expectedSqrt101 = Roots.squareRootIterative(101);
		double expectedSqrt1043 = Roots.squareRootIterative(1043);
		double expectedSqrt12345 = Roots.squareRootIterative(12345);
		double expectedSqrt123456 = Roots.squareRootIterative(123456);

		assertEquals(expectedSqrt10, sqrt10, 0.1);
		assertEquals(expectedSqrt101, sqrt101, 0.1);
		assertEquals(expectedSqrt1043, sqrt1043, 0.1);
		assertEquals(expectedSqrt12345, sqrt12345, 0.1);
		assertEquals(expectedSqrt123456, sqrt123456, 0.1);
	}
}
