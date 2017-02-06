package com.doublylinkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void test() {
		DoublyLinkedNode node = new DoublyLinkedNode(1);
		node.appendToTail(2);
		node.appendToTail(3);
		final int firstNode = node.getData();
		node = node.next;
		final int secondNodePrevious = node.previous.getData();
		assertEquals(firstNode, secondNodePrevious);
	}

}
