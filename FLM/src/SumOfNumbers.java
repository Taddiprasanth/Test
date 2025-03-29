import java.util.Scanner;

public class SumOfNumbers {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the value of a: ");
		int a=scan.nextInt();
		int sum=0,sum1=0;
		for(int i=1;i<=a;i++) {
			System.out.print(i+" ");
			sum+=i;
		}
		int count=0;
		System.out.println();
		for(int i=1;i<=a;i++) {
			if(i*i<=25000) {
				count++;
				System.out.print(i*i+" ");
				sum1+=(i*i);
			}
		}
		System.out.println();
		System.out.println("The sum of all the numbers is "+sum);
		System.out.println("The sum of all square numbers is  "+sum1);
		System.out.println(count);
	}

}
