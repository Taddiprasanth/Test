package com.thread;

import java.util.Scanner;

public class FabonacciNumberThread extends Thread{
	@Override
	public synchronized void run() {
		try(Scanner scan=new Scanner(System.in)){
			System.out.println("Enter the upto which number you wanted to println the Fabonacci series");
			int a=scan.nextInt();
			int b1=0;
			int b2=1;
			int b3=0;
			System.out.println(Thread.currentThread().getName()+"--->"+b1);
			System.out.println(Thread.currentThread().getName()+"--->"+b2);
			for(int i=0;i<=a;i++) {
				b3=b1+b2;
				System.out.println(Thread.currentThread().getName()+"--->"+b3);
				b1=b2;
				b2=b3;
			}
			
		}catch(Exception Ex) {
			System.out.println("Error"+Ex.getMessage());
		}
	}
}
