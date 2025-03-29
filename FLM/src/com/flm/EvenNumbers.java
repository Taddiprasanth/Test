package com.flm;

import java.util.Scanner;

public class EvenNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum=0;
		while (true) {
			System.out.print("Enter the value of a :");
			int a = scan.nextInt();
			if (a == 0)
				break;
			if (a % 2 == 0) {
				System.out.println(a + " is a even number");
				sum+=a;
			} else {
				System.out.println(a + " is not a even number");
			}

		}
		System.out.println(sum);
	}
}
