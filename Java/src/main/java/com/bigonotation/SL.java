package com.bigonotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SL {

	static String[] Mids = new String[] { "MSI", "MSU", "MSV", "MSI", "MSU", "MSV" };
	static String[] sl = new String[] { "MSU", "MSV", "MSS", "MSU", "MSV", "MSS" };

	public static void main(String[] args) {
		final long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < sl.length; i++) {
			boolean found = false;
			for (int j = 0; j < Mids.length; j++) {
				if ((sl[i].equals(Mids[j]))) {
					found = true;
					break;
				}
			}

			if (found) {
				System.out.println("Action");
			} else {
				System.out.println("Action cannot be set");
			}
		}
		final long endTime1 = System.currentTimeMillis();
		System.out.println("Time1: " + (endTime1 - startTime1));

		final long startTime2 = System.currentTimeMillis();

		List<String> midsList = new ArrayList<String>(Arrays.asList(Mids));
		for (String string : sl) {
			if (midsList.contains(string)) {
				System.out.println("Action");
			} else {
				System.out.println("Action cannot be set");
			}
		}
		final long endTime2 = System.currentTimeMillis();
		System.out.println("Time2 " + (endTime2 - startTime2));
	}
}
