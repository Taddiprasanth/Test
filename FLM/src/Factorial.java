import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the value of a :");
		int a = scan.nextInt();
		int factorial=1;
		int sum=0;
		System.out.println( );
		if (a >= 0) {
			if (a == 0 || a == 1) {
				System.out.println("The factorial value of"+ a+" is "+ factorial);
			} else {
				for (int i = 1; a>= i; i++) {
					System.out.print(factorial*i+" ");
					sum+=(factorial*i);
				}
				System.out.println( );
				System.out.println("The sum of factorial of  "+a+" is"+sum);
			}
		}else {
			System.out.println("Please enter the valid value of a :"+a);
		}
	}

}
