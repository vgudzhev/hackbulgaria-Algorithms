package com.vgudzhev.tasks.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import com.vgudzhev.tasks.Brackets;


public class BracketsTests {

	@Test
	public void testChecBrackets() {
		assertTrue(Brackets.checkBrackets("(123)"));
		assertTrue(Brackets.checkBrackets("[(123)(123)]"));
		assertTrue(Brackets.checkBrackets("[23(123)12(123)]"));
		assertTrue(Brackets.checkBrackets("{123[123(123)123(123)]23[123]2}"));
		assertTrue(Brackets.checkBrackets("[123]"));
		assertTrue(Brackets.checkBrackets("{123}]"));
		
		assertFalse(Brackets.checkBrackets("123(123)"));
		assertFalse(Brackets.checkBrackets("(123[123])"));
		assertFalse(Brackets.checkBrackets("[123(123])"));
		assertFalse(Brackets.checkBrackets("[123{123}]"));
		assertFalse(Brackets.checkBrackets("(123)(123)"));
		assertFalse(Brackets.checkBrackets("[123][123]"));
	}
	
	@Test
	public void testSolve(){
		assertEquals(Brackets.solve("[123(145)38(37)812]"), "1337");
		assertEquals(Brackets.solve("{125[2][(1)][3]125}"), "264");
		assertEquals(Brackets.solve("[125()125()125()125]"), "500");
		assertEquals(Brackets.solve("{125()125}"), "NO");
		assertEquals(Brackets.solve("{125[12]{125}[12]125}"), "NO");
		assertEquals(Brackets.solve("{125[12(123]125}"), "NO");
		
	}

}
