package com.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test
	public void test() {
		Queue queue = new Queue();
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(1);
		assertEquals(3, queue.dequeue().getData());
		assertEquals(2, queue.dequeue().getData());
	}

}
