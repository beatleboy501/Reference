package com.linkedlist;

import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

	@Test
	public void test() {
		Node node = new Node(1);
		node.appendToTail(2);
		node.appendToTail(3);
		node.appendToTail(4);
		node.deleteNode(node, 2);
		while (node != null) {
			Assert.assertNotEquals(2, node);
			System.out.println(node.getData());
			node = node.next;
		}
	}

	@Test
	public void removeDuplicatesTest() {

		Node node = node();
		Set<Integer> set = new TreeSet<Integer>();
		while (node != null) {
			set.add(node.getData());
			node = node.next;
		}
		System.out.println(set.toString());
	}
	
	private Node node() {
		Node node = new Node(1);
		node.appendToTail(2);
		node.appendToTail(2);
		node.appendToTail(1);
		node.appendToTail(3);
		node.appendToTail(4);
		node.appendToTail(4);
		return node;
	}

	@Test
	public void deleteDups() {
		Node n = node();
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node previous = null;
		while (n != null) {
			if (table.containsKey(n.data))
				previous.next = n.next;
			else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
}
