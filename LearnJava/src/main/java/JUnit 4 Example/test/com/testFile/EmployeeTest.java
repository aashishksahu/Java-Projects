package com.testFile;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.sourceFile.Employee;

public class EmployeeTest {

	@Test
	public void testFindName() {
		
		ArrayList<String> emplist = new ArrayList<>();
		
		emplist.add("Ram");
		emplist.add("Ham");
		emplist.add("Sam");
		emplist.add("Cam");
		emplist.add("Jam");
		
		Employee e = new Employee();
		assertEquals("FOUND", e.findName(emplist, "Sam"));
		assertEquals("NOT FOUND", e.findName(emplist, "Harris"));
	}

}
