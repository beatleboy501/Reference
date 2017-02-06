package com.linkedlist;

public class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	int getData() {
		return data;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public Node returnNthToLast(Node head, int n) {
		if (head == null || n < 1) {
			return null; // if not enough nodes in linkedlist
		}

		Node pointer1 = head;
		Node pointer2 = head;
		for (int j = 0; j < n - 1; ++j) { // try to create n spaces between 2
											// pointers
			if (pointer2 == null) {
				return null;
			}
			pointer2 = pointer2.next; // it will eventually stop at Node n - 1
		}

		while (pointer2.next != null) { // run until the last node "falls off"
			pointer1 = pointer1.next; // pointer one is always n steps behind
										// pointer two
			// pointer one will return nth to last
			pointer2 = pointer2.next;
		}
		return pointer1;
	}

	// Deleting a node from a linked list
	Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return head.next; /* moved head */
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head; /* head didn’t change */
			}
			n = n.next;
		}
		return n;
	}
}