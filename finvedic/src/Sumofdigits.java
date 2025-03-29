import java.util.Scanner;

public class Sumofdigits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number ");
		int a = scan.nextInt();
		int sum = 0;
		while (a!= 0) {
			sum = sum + a % 10;
			a = a / 10;
		}
		System.out.println(sum);
	}
}