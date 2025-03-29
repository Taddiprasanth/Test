package array.com.examples;

import java.util.Scanner;

public class DeclarationOfArray {
	Scanner scan = new Scanner(System.in);
	int a = scan.nextInt();
	int array[] = new int[a];

	public void fillingOfArray() {
		for (int i = 0; i < array.length; i++) {
			int b = scan.nextInt();
			array[i] = b;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
