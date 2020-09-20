package com.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.testFile.Demo1Test;
import com.testFile.Demo2Test;
import com.testFile.EmployeeTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ Demo1Test.class, Demo2Test.class, EmployeeTest.class })

public class TestSuite {

}
