import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {

        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }
}

public class task3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(10000);

        int choice;

        do {

            System.out.println("\n========== ATM ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance : ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount : ₹");
                    double deposit = sc.nextDouble();

                    if (deposit > 0)
                        account.deposit(deposit);
                    else
                        System.out.println("Invalid Amount!");

                    break;

                case 3:
                    System.out.print("Enter Withdraw Amount : ₹");
                    double withdraw = sc.nextDouble();

                    if (withdraw > 0)
                        account.withdraw(withdraw);
                    else
                        System.out.println("Invalid Amount!");

                    break;

                case 4:
                    System.out.println("Thank You for using ATM.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
