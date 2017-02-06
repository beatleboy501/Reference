package com.linkedlist;

import java.util.Hashtable;

public class RemoveDuplicateNode {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Node node = createDuplicateNodes();
		removeDuplicateNodes(node);
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " milliseconds");
		start = System.currentTimeMillis();
		Node node2 = createDuplicateNodes();
		deleteDups2(node2);
		while (node2 != null) {
			System.out.println(node2.data);
			node2 = node2.next;
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + " milliseconds");
	}

	public static void removeDuplicateNodes(Node n) {
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

	public static void deleteDups2(Node head) {
		if (head == null)
			return;
		Node previous = head;
		Node current = previous.next;
		while (current != null) {
			Node runner = head;
			while (runner != current) { // Check for earlier dups
				if (runner.data == current.data) {
					Node tmp = current.next; // remove current
					previous.next = tmp;
					current = tmp; // update current to next node
					break; // all other dups have already been removed
				}
				runner = runner.next;
			}
			if (runner == current) { // current not updated - update now
				previous = current;
				current = current.next;
			}
		}
	}

	public static Node createDuplicateNodes() {
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(1);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(1);
		n.appendToTail(5);
		n.appendToTail(2);
		n.appendToTail(6);
		n.appendToTail(7);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(1);
		n.appendToTail(1);
		n.appendToTail(9);
		n.appendToTail(5);
		n.appendToTail(10);
		n.appendToTail(2);
		n.appendToTail(1);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(1);
		n.appendToTail(5);
		n.appendToTail(2);
		n.appendToTail(6);
		n.appendToTail(7);
		n.appendToTail(21);
		n.appendToTail(13);
		n.appendToTail(12);
		n.appendToTail(11);
		n.appendToTail(19);
		n.appendToTail(15);
		n.appendToTail(10);
		n.appendToTail(20);
		n.appendToTail(12);
		n.appendToTail(3);
		n.appendToTail(14);
		n.appendToTail(11);
		n.appendToTail(54);
		n.appendToTail(23);
		n.appendToTail(16);
		n.appendToTail(17);
		n.appendToTail(12);
		n.appendToTail(31);
		n.appendToTail(10);
		n.appendToTail(1);
		n.appendToTail(19);
		n.appendToTail(35);
		n.appendToTail(10);
		return n;

	}

}
