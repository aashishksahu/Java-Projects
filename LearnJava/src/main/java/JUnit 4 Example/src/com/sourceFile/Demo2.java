package com.sourceFile;

public class Demo2 {

	public boolean palindromeCheck(String text) {
		boolean result = false;

		text = text.toLowerCase();

		StringBuffer textBuffer = new StringBuffer(text);

		String reverseText = textBuffer.reverse().toString();

		if (text.equals(reverseText)) {
			result = true;
		}

		return result;

	}

}
