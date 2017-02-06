package com.towersofhanoi;

public class Disk {
	public Disk next = null;
	public Disk previous = null;
	int data;

	public Disk(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void appendToTail(int newData) {
		Disk end = new Disk(newData);
		Disk n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
		end.previous = n;
	}

	public Disk returnNthToLast(Disk head, int n) {
		if (head == null || n < 1) {
			return null; // if not enough nodes in linkedlist
		}

		Disk pointer1 = head;
		Disk pointer2 = head;
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

	public Disk deleteNode(Disk head, int d) {
		Disk n = head;
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
