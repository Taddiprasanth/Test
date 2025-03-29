package array.com.examples;

import java.util.Scanner;

public class Reverse {

	Scanner sc = new Scanner(System.in);
	int size = sc.nextInt();
	int array[] = new int[size];

	public void Array() {
		for (int i = 0; i < array.length; i++) {
			int values = sc.nextInt();
			array[i] = values;
		}
		System.out.println("Array elements before reverse of elements ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public void order() {
		System.out.println(" ");
		System.out.println("reverse of the array elements");
		for (int i = (array.length - 1); i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");

	}
}
