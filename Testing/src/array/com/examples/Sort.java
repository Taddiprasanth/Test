package array.com.examples;

import java.util.Scanner;

public class Sort {
	Scanner scan = new Scanner(System.in);
	int a = scan.nextInt();
	int array[] = new int[a];
	
	public void Array() {
		for (int i = 0; i < array.length; i++) {
			int b = scan.nextInt();
			array[i] = b;
		}
		System.out.println("Before sorting of array");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	public void Order() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j <array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("After sorting of array :");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}
}
