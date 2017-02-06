package com.bigonotation;


import org.junit.Ignore;
import org.junit.Test;

import com.bigonotation.FindExtra;

public class FindExtraTest {
	
	String[] aaa = new String[]{"cat","dog","monkey"};
	String[] bbb = new String[]{"cat","dog","monkey", "rat"};
	
	//1000
	//5000
	//10000
	//50000
	
	private String[] getArrayA(){
		String[] array = new String[10000];
		for(int i = 0; i < 9999; i++){
			array[i] = "dog" + i;
		}
		return array;
	}
	private String[] getArrayB(){
		String[] array = new String[10001];
		for(int i = 0; i < 9999; i++){
			array[i] = "dog" + i;
		}
		array[10000] = "cat";
		return array;
	}
	
	final String[] a = getArrayA();
	final String[] b = getArrayB();

	@Test
	public void testUsingNestedForLoop() {
		String result = FindExtra.usingNestedForLoop(a, b);
		System.out.println(result);
	}

	@Test
	public void testUsingCollection() {
		String result = FindExtra.usingCollection(a, b);
		System.out.println(result);
	}
	
	@Ignore
	public void testUsingList() {
		String result = FindExtra.usingList(a, b);
		System.out.println(result);
	}
	
	@Test
	public void testUsingSet() {
		String result = FindExtra.usingSet(a, b);
		System.out.println(result);
	}
	
	@Test
	public void testUsingOn() {
		String result = FindExtra.usingOn(a, b);
		System.out.println(result);
	}
	
	@Ignore
	public void testUsingIntersect() {
		String result = FindExtra.usingIntersect(a, b);
		System.out.println(result);
	}
}
