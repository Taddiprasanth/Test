import java.util.Scanner;

public class AdditionsOfNumbers {

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.print("Enter how many numbers you wanted to add :");
		int value=scan.nextInt();
		int sum=0;
		for(int i=1;i<=value;i++) {
			System.out.print("Enter the" +i+"value :");
			int a=scan.nextInt();
			sum +=a;
		}
		System.out.println(sum);
	}
}
