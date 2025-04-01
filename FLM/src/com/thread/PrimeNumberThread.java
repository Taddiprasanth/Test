package com.thread;

import java.util.Scanner;

public class PrimeNumberThread implements Runnable {

	@Override
	public synchronized void run() {
		try(Scanner scan=new Scanner(System.in)){
			System.out.println("Enter the Prime number limit");
			int b=scan.nextInt();
			int c=0,a;
			for(int i=1; i<=b;i++) {
				int count=0;
				for(int j=1;j<=i;j++) {
					a=i%j;
					if(a==0) 
						count++;
				}
				if(count==2) {
					System.out.println(i);
					c++;
				}
			}
			System.out.println("The prime number count is "+c);
			
		}catch(Exception ex){
			System.out.println("Error"+ ex.getMessage());
		}
	}

}
