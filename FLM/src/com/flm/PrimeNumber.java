package com.flm;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Upto which number you wanted to print the prime number");
		int a = scan.nextInt();
		int b, total = 0;
		for (int i = 2; i <= a; i++) {
			int count = 0;
			for (int j = 1; j <= i; j++) {
				b = (i % j);
				if (b == 0)
					count++;
			}
			if (count == 2) {
				System.out.println(i + " is a prime number ");
				total++;
			}
		}
		System.out.println(total);
	}
}
