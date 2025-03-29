package com.array;

import java.util.Scanner;

public class SqaresOfNumbersInArray {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the Value of the P : ");
		int p=scan.nextInt();
		int [] nums=new int[p];
		System.out.println();
		for(int i=0;i<nums.length;i++) {
			System.out.print("Enter the Valus of the array at "+i+" position :");
			nums[i]=scan.nextInt();
		}
		System.out.println();
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
		
	}

}
