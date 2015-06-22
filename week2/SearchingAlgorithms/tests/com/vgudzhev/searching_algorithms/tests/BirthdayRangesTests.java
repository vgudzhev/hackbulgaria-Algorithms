package com.vgudzhev.searching_algorithms.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.vgudzhev.searching_algorithms.tasks.BirthdayRanges;
import com.vgudzhev.searching_algorithms.tasks.BirthdayRanges.Pair;

public class BirthdayRangesTests {
	private final Pair JANUARY = new Pair(0, 30);
	private final Pair FEBRUARY = new Pair(31, 59);
	private final Pair MARCH = new Pair(60, 90);
	private final Pair APRIL = new Pair(91, 121);

	private final int BORN_IN_JANUARY = 1;
	private final int BORN_IN_FEBRUARY = 10;
	private final int BORN_IN_MARCH = 100;
	private final int BORN_IN_APRIL = 0;

	@Test
	public void test() {
		List<Integer> birthdays = new ArrayList<Integer>();
		
		// 1 born in JANUARY
		birthdays.add(1);
		
		// 10 born in FEBRYARY
		for (int i = 0; i < BORN_IN_FEBRUARY; i++) {
			birthdays.add(32);
		}
		
		// 100 born in MARCH
		for (int i = 0; i < BORN_IN_MARCH; i++) {
			birthdays.add(61);
		}
		
		// 0 born in april
		
		List<Pair> ranges = new ArrayList<Pair>();
		ranges.add(JANUARY);
		ranges.add(FEBRUARY);
		ranges.add(MARCH);
		ranges.add(APRIL);
		
		List<Integer> expected =  BirthdayRanges.birthdaysCount(birthdays, ranges);
		List <Integer> actual = new ArrayList<Integer>();
		actual.add(BORN_IN_JANUARY);
		actual.add(BORN_IN_FEBRUARY);
		actual.add(BORN_IN_MARCH);
		actual.add(BORN_IN_APRIL);
		
		boolean areEqual = true;
		int currentActual;
		int currentExpected;
		for (int i = 0; i < expected.size(); i++) {
			currentActual = expected.get(i);
			currentExpected  =actual.get(i);
			if (currentActual != currentExpected) {
				areEqual = false;
				break;
			}
		}
		
		assertTrue(areEqual);
	}
}
