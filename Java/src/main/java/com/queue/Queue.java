package com.queue;

import com.doublylinkedlist.DoublyLinkedNode;

public class Queue {

	DoublyLinkedNode front, back;
	void enqueue(int item) {
		if (back == null) {
			back = new DoublyLinkedNode(item);
			front = back;
		} else {
			back.next = new DoublyLinkedNode(item);
			back = back.next;
		}
	}

	DoublyLinkedNode dequeue() {
		if (front != null) {
			DoublyLinkedNode item = front;
			front = front.next;
			return item;
		}
		return null;
	}
}