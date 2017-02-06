package com.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void testPop() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(3, stack.pop().getData());
	}

	@Test
	public void testPush() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		assertNotSame(1, stack.pop().getData());
	}

	@Test
	public void testGetMin() {
		Stack stack = new Stack();
		stack.push(4);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(1, stack.getMin().getData());
	}

}
