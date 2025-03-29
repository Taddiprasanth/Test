import java.util.Scanner;

public class CreditCardNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = new String();
		System.out.print("Enter the card number : ");
		str = scan.nextLine();
		int a = str.length(), result = 0;
		int b[] = new int[a];
		int card[] = new int[a];
		if (a == 16) {
			for (int i = 0; i < a; i++) {
				char c = str.charAt(i);
				b[i] = c - '0';
			}
			System.out.println(" ");
			for (int i = 0; i < a; i++) {
				if (i % 2 == 0) {
					int temp = b[i] * 2;
					if (temp > 9) {
						temp = temp % 10 + 1;
					} else {
						card[i] = temp;
					}
					card[i] = temp;
				} else {
					int temp = b[i] * 1;
					card[i] = temp;
				}
				System.out.print(b[i] + " ");
			}
			System.out.println(" ");
			for (int i = 0; i < a; i++) {
				result = result + card[i];
				System.out.print(card[i] + " ");
			}
			if (result % 10 == 0)
				System.out.println("The credit card is Valid");
			else
				System.out.println("The credit card is Invalid");
		} else {
			System.out.println("You enter the card number is less than 16 digits");
		}
		scan.close();
	}
}
