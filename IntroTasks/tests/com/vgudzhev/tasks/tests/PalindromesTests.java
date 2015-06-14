package com.vgudzhev.tasks.tests;
import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromesTests {

	@Test
	public void testSingleLetter() {
		String input = "a";
		
		String expected = com.vgudzhev.tasks.Palindromes.solve(input);
		String actual = "a";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testValidPalndrome1() {
		String input = "labalaa";
		
		String expected = com.vgudzhev.tasks.Palindromes.solve(input);
		String actual = "alabala";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testValidPalindrome2() {
		String input = "akawwaka";
		
		String expected = com.vgudzhev.tasks.Palindromes.solve(input);
		String actual = "wakaakaw";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInvalidPalindrome() {
		String input = "shakira";
		
		String expected = com.vgudzhev.tasks.Palindromes.solve(input);
		String actual = "NONE";
		
		assertEquals(expected, actual);
	}
}
