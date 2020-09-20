package com.testFile;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sourceFile.Demo2;

public class Demo2Test {

	@Test
	public void testPalindromeCheck() {
		Demo2 d = new Demo2();

		assertEquals(true, d.palindromeCheck("malayalam"));
		assertEquals(true, d.palindromeCheck("Malayalam"));
		assertEquals(false, d.palindromeCheck("kangaroo"));
		assertEquals(false, d.palindromeCheck("abc123"));
		assertEquals(true, d.palindromeCheck("12321"));
	}

}
