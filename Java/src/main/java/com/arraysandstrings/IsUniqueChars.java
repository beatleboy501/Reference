package com.arraysandstrings;

public class IsUniqueChars {
	/*
	 * Implement an algorithm to determine if a string has all unique
	 * characters. What if you can not use additional data structures?
	 */

	public static void main(String[] args) {
		String alphaStringTrue = "abcdefghijklmnopqrstuvwxyz";
		String alphaStringFalse = "abcdefghijklmnopqrstuvwxyz";
		String string = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-+=";
		String string2 = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-+=}{[]|'.,><~`?/;:";
		String string3 = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-+=}{[]|'.,><~`?/;: a";
		
		System.out.println(isUniqueChars(alphaStringTrue));
		System.out.println(isUniqueChars2(alphaStringTrue));
		System.out.println(isUniqueChars(alphaStringFalse));
		System.out.println(isUniqueChars2(alphaStringFalse));

		System.out.println(isUniqueChars2(string));
		System.out.println(isUniqueChars2(string2));
		System.out.println(isUniqueChars2(string3));

	}

	/*
	 * Time complexity is O(n), where n is the length of the string, and space
	 * complexity is O(n).
	 */
	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	/*
	 * We can reduce our space usage a little bit by using a bit vector. We will
	 * assume, in the below code, that the string is only lower case ‘a’ through
	 * ‘z’. This will allow us to use just a single integer.
	 */
	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i);
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	/*
	 * Alternatively, we could do the following: 
	 * 1. Check every char of the
	 * string with every other char of the string for duplicate occurrences.
	 * This will take O(n^2) time and no space. 
	 * 2. If we are allowed to destroy
	 * the input string, we could sort the string in O(n log n) time and then
	 * linearly check the string for neighboring characters that are identical.
	 * Careful, though - many sorting algorithms take up extra space.
	 */
}
