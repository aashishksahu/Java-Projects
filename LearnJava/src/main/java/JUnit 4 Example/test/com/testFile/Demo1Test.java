package com.testFile;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sourceFile.Demo1;

public class Demo1Test {

	@Test
	public void testStringConcat() {
		Demo1 d = new Demo1();
		assertEquals("onetwo", d.stringConcat("one", "two"));
	}

}
