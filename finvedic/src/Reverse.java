import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the string:");
		String str=new String();
		str=scan.nextLine();
		System.out.println(" ");
		System.out.print("The reverse String is :");
		for(int i=str.length()-1; i>=0;i--) {
			System.out.print(str.charAt(i));
		}
	}

}
