import java.util.Scanner;

public class SumOfNumberBy3 {
	public static void main(String[] args) {
		Scanner Prasanth=new Scanner(System.in);
		System.out.print("Please enter the value : ");
		int a=Prasanth.nextInt();
		System.out.println();
		for(int i=3;i<=a;i+=4) {
			System.out.print(i+" ");
		}
	}
}
