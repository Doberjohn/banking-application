import java.util.Scanner;

class ATM {
    private CreditCard creditCard;
    private int previousTransaction;
    private final Scanner scanner = new Scanner(System.in);

    public ATM() {}

    private void depositMoney(int amount) {
        if (amount != 0) {
            creditCard.addBalance(amount);
            previousTransaction = amount;
        }
    }

    private void withdrawMoney(int amount) {
        if (amount != 0) {
            creditCard.removeBalance(amount);
            previousTransaction = amount;
        }
    }

    private void showPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction + creditCard.getCurrency());
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction) + creditCard.getCurrency());
        } else {
            System.out.println("No transaction available");
        }
    }

    private void showCustomerBalance() {
        System.out.println("\n");
        System.out.println("============================");
        System.out.println("Your current balance is " + creditCard.getBalance() + creditCard.getCurrency());
        System.out.println("============================");
    }

    private void showWelcomeMessage() {
        System.out.println("Welcome " + creditCard.getCustomerName());
        System.out.println("Your card number is " + creditCard.getCreditCardNumber());
        System.out.println("\n");
    }

    private void showAvailableTransactions() {
        System.out.println("======================");
        System.out.println("Available transactions");
        System.out.println("======================");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Previous transaction");
        System.out.println("5. Exit");
        System.out.println("==========================");
        System.out.print("Enter transaction code: ");
    }

    private void showGoodbyeMessage() {
        System.out.println("===============================================");
        System.out.println("Thank you dear customer. Hope to see you again!");
        System.out.println("===============================================");
    }

    public void insertCard(CreditCard card) {
        this.creditCard = card;

        showWelcomeMessage();

        char transactionCode;
        do {
            showAvailableTransactions();

            transactionCode = scanner.next().charAt(0);

            switch (transactionCode) {
                case '1': {
                    showCustomerBalance();
                    break;
                }
                case '2': {
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = scanner.nextInt();
                    depositMoney(depositAmount);
                    showCustomerBalance();
                    break;
                }
                case '3': {
                    System.out.print("Enter withdraw amount: ");
                    int withdrawAmount = scanner.nextInt();
                    withdrawMoney(withdrawAmount);
                    showCustomerBalance();
                    break;
                }
                case '4': {
                    showPreviousTransaction();
                    break;
                }
                default: {
                    break;
                }
            }

            System.out.println("\n");
        } while (transactionCode != '5');

        showGoodbyeMessage();
    }
}
