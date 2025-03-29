import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = new String();
		// System.out.print("Enter the String:");
		str = scan.nextLine();
		String b = new String();
		for (int i = str.length() - 1; i >= 0; i--) {
			char a = 0;
			a = str.charAt(i);
			b += a;
		}
		System.out.println(" ");
		if (b.equals(str)) {
			System.out.println("It is a Palindrome");
		} else {
			System.out.println("It is not a palindrome");
		}
	}
}
