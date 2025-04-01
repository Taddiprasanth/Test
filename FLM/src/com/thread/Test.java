package com.thread;

public class Test {

	public static void main(String[] args) {
		Thread t1=new Thread(new PrimeNumberThread());
		t1.start();
		Thread t2=new FabonacciNumberThread();
		t2.start();
	}

}
