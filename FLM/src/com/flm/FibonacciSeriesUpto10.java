package com.flm;

import java.util.Scanner;

public class FibonacciSeriesUpto10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("how many numbers you wants");
		int a = 0;
		int b = 1, temp = 0, count = 0;
		int c = scan.nextInt();
		System.out.print(a + "," + b);
		/*
		 * for(int i=0;i<c;i++) { temp=a+b; //if (temp>10) break;
		 * System.out.print(","+temp); a=b; b=temp; } while((a+b)<=c) { temp=a+b; //if
		 * (temp>10) break; System.out.print(","+temp); a=b; b=temp; }
		 */
	}
}
