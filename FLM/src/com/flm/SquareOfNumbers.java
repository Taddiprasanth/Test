package com.flm;

import java.util.Scanner;

public class SquareOfNumbers {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter how manyn square values you wanted to print :");
		int a=scan.nextInt();
		int sum=0;
		for(int i=1;i<=a;i++)
		{
			System.out.print(i*i+", ");
			sum+=(i*i);
		}
		System.out.println( );
		System.out.println("The sume of the Square of values is "+sum);
		
	}

}
