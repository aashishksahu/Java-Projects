package com.testSuite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result testResult = JUnitCore.runClasses(TestSuite.class);

		for (Failure failedTest : testResult.getFailures()) {
			System.out.println(failedTest.toString());
		}

		System.out.println(testResult.wasSuccessful());
	}

}
