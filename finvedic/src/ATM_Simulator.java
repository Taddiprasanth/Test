import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String type;
    private double amount;
    private Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date(); 
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00"); // Format numbers
        return type + " of $" + df.format(amount) + " on " + date;
    }
}

class ATM {
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;
    private DecimalFormat df = new DecimalFormat("#,##0.00"); // Number formatting

    public ATM(String pin) {
        this.pin = pin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validatePIN(String inputPIN) {
        return this.pin.equals(inputPIN);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposited $" + df.format(amount) + ". New balance: $" + df.format(balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", amount));
        System.out.println("Withdrawn $" + df.format(amount) + ". Remaining balance: $" + df.format(balance));
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + df.format(balance));
    }

    public void getTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }
        System.out.println("\nTransaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class ATM_Simulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM("1234"); // Default PIN: 1234

        System.out.print("Enter your PIN: ");
        String enteredPIN = scanner.nextLine();

        if (!atm.validatePIN(enteredPIN)) {
            System.out.println("Invalid PIN. Access Denied.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;

                case 4:
                    atm.getTransactionHistory();
                    break;

                case 5:
                    System.out.println("Exiting ATM. Have a great day!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
