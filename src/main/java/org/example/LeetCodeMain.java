package org.example;

public class LeetCodeMain {
	public static void main(String [] args) {
		System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
	}

	public static int compress(char[] chars) {
		int index = 0;
		int writePointer = 0;
		char previousChar = chars[index];
		int currentCount = 0;

		while (index < chars.length) {
			if (previousChar == chars[index]) currentCount++;
			else {
				chars[writePointer++] = previousChar;

				if (currentCount > 1) {
					for (char c : String.valueOf(currentCount).toCharArray()) {
						chars[writePointer++] = c;
					}
				}

				previousChar = chars[index];
				currentCount = 0;
				continue;
			}
			index++;
		}

		chars[writePointer++] = previousChar;

		if (currentCount > 1) {
			for (char c : String.valueOf(currentCount).toCharArray()) {
				chars[writePointer++] = c;
			}
		}

		return writePointer;
	}
}

