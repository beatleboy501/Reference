package com.towersofhanoi;

public class Application {
	static Rod rod1;
	static Rod rod2;
	static Rod rod3;

	public static void init() {
		rod1 = new Rod();
		rod2 = new Rod();
		rod3 = new Rod();
		rod1.push(3);
		rod1.push(6);
		rod1.push(9);
	}

	public static void slideOn(Rod from, Rod to) {
		for (Integer i = from.pop(); i != null; i = from.pop()) {
			to.push(i);
		}
	}
	
	public static void main(String[] args) {
		init();
		slideOn(rod1, rod2);
		slideOn(rod2, rod3);
	}
}
