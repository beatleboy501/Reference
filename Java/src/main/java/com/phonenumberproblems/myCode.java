package com.phonenumberproblems;
/* package whatever; // don't place package name! */

import java.util.*;

public class myCode {
	public static void main(String[] args) throws java.lang.Exception {

		printAllNumbers(7);
	}

	public static void printAllNumbers(int length) throws java.lang.Exception {
		if(length <= 0){
			throw new java.lang.Exception("invalid length");
		}
		Set<String> allTheNumbers = new HashSet<String>(); // no duplicates
		for (int i = 0; isTooLong(i, length); i++) {
			parseNumber(i, length, allTheNumbers);
		}
		for(String number : allTheNumbers){
			System.out.println(number);
		}
	}

	private static void parseNumber(int currentNumber, int length, Set<String> allTheNumbers) {
		
		String current = currentNumber + "";
		String[] disallowedNumbers = new String[] { "7", "2", "9" };
		for (String disallowed : disallowedNumbers) {
			if (current.contains(disallowed)) {
				return;
			}
		}
		if (current.contains("4")) {
			current = String.format("%0" + length + "d", Integer.parseInt(current));
			int countOfFours = current.length() - current.replace("4", "").length();
			current = current.replace("4", "");
			StringBuilder output = new StringBuilder();
			for (int i = 0; i < countOfFours; i++) {
				output.append("4");				
			}
			output.append(current);
			allTheNumbers.add(output.toString());
		}
		else{
			allTheNumbers.add(String.format("%0" + length + "d", currentNumber));
		}
	}

	public static boolean isTooLong(int num, int limit) {
		int length = (int) Math.log10(num);
		if (length > limit - 1) {
			return false;
		}
		return true;
	}

}
