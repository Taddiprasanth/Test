import java.util.Scanner;

public class BankManagement {

	private int amount = 1000;
	Scanner scan = new Scanner(System.in);

	public int setDeposite() {
		System.out.println("How much amount your are deposite:");
		int amount = scan.nextInt();
		this.amount = this.amount + amount;
		return amount;
	}

	public void withdraw() {
		System.out.println("Please enter the amount how much your are withdram;");
		int D = scan.nextInt();
		if (amount - D >= 500) {
			amount = amount - D;
		} else {
			System.out.println("The minimum balance of your account is 500 ");
			System.out.println("The current balance is:" + amount);
		}
	}

	public int Balance() {
		System.out.println("The remaining Balance is :");
		return amount;
	}

	public static void main(String[] args) {
		BankManagement b = new BankManagement();
		b.setDeposite();
		b.withdraw();
		System.out.println(b.Balance());
	}

}
