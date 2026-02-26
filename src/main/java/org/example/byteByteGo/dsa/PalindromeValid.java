package org.example.byteByteGo.dsa;

public class PalindromeValid {
	public static void main(String [] args) {
		System.out.println(is_palindrome_valid("a dog! a panic in a pagoda."));
	}

	public static Boolean is_palindrome_valid(String s) {
		int i = 0, j = s.length() - 1;

		while (i <= j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

			if (s.charAt(i) != s.charAt(j)) return false;

			i++;
			j--;
		}
		return true;
	}
}

/**
 * Is Palindrome Valid
 * Easy
 * A palindrome is a sequence of characters that reads the same forward and backward.
 *
 * Given a string, determine if it's a palindrome after removing all non-alphanumeric characters. A character is alphanumeric if it's either a letter or a number.
 *
 * Example 1:
 * Input: s = 'a dog! a panic in a pagoda.'
 * Output: True
 * Example 2:
 * Input: s = 'abc123'
 * Output: False
 * Constraints:
 * The string may include a combination of lowercase English letters, numbers, spaces, and punctuations.*/
