import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the number :");
		int a=scan.nextInt();
		int b=0,c=0;
		for(int i=1;i<=a;i++) {
			b=a%i;
			if(b==0) {
				c=c+1;
			}
		}
		if(c==2) {
			System.out.println(a+" is a Prime number");
		}else {
			System.out.println(a+" is not a Prime Number");
		}
	}
}
