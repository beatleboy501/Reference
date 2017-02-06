package com.stack;

import com.doublylinkedlist.DoublyLinkedNode;

public class Stack {
	public DoublyLinkedNode top;
	public DoublyLinkedNode min;

	public DoublyLinkedNode pop() {
		if (top != null) {
			DoublyLinkedNode item = top;
			top = top.next;
			return item;
		}
		return null;
	}

	public void push(int item) {
		DoublyLinkedNode t = new DoublyLinkedNode(item);
		if ((min == null) || (item < min.getData())) {
			min = t;
		}
		t.next = top;
		top = t;
	}

	public DoublyLinkedNode getMin() {
		return min;
	}
}