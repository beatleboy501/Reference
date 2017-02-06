package com.towersofhanoi;

public class Rod {
	public Disk top;
	public Disk bottom;

	public Integer pop() {
		if (top != null) {
			Disk item = top;
			top = top.next;
			return item.data;
		}
		return null;
	}

	public void push(int item) {
		Disk t = new Disk(item);
		if ((bottom == null) || (item < bottom.getData())) {
			bottom = t;
		}
		t.next = top;
		top = t;
	}

	public Disk getMin() {
		return bottom;
	}
}
