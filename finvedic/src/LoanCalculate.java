import java.util.Scanner;

public class LoanCalculate {

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.print("Enter the Principal amount : ");
		double p=scan.nextInt();
		System.out.println(" ");
		System.out.print("Enter the rate of Interest : ");
		float i=scan.nextFloat();
		System.out.println(" ");
		System.out.print("Enter the long term of your payments:");
		int b=scan.nextInt();
		System.out.println(" ");
		int months=b*12;
		double amount=0;
		double temp=Math.pow((i+1), months);
		amount=p*((i*temp)/(temp-1));
		System.out.println(amount);
		scan.close();
	}

	
}
