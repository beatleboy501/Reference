package com.doublylinkedlist;

public class DoublyLinkedNode {
	public DoublyLinkedNode next = null;
	public DoublyLinkedNode previous = null;
	int data;

	public DoublyLinkedNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void appendToTail(int newData) {
		DoublyLinkedNode end = new DoublyLinkedNode(newData);
		DoublyLinkedNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
		end.previous = n;
	}

	public DoublyLinkedNode returnNthToLast(DoublyLinkedNode head, int n) {
		if (head == null || n < 1) {
			return null; // if not enough nodes in linkedlist
		}

		DoublyLinkedNode pointer1 = head;
		DoublyLinkedNode pointer2 = head;
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

	public DoublyLinkedNode deleteNode(DoublyLinkedNode head, int d) {
		DoublyLinkedNode n = head;
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
