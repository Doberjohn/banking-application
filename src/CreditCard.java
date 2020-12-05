import java.util.concurrent.ThreadLocalRandom;

public class CreditCard {
    private Integer balance;
    private final String customerName;
    private final String currency;
    private final int creditCardNumber;

    public CreditCard(String customerName, String currency) {
        this.balance = 0;
        this.currency = currency;
        this.customerName = customerName;
        this.creditCardNumber = ThreadLocalRandom.current().nextInt(100000000, 999999999);
    }


    public String getCustomerName() {
        return customerName;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public void removeBalance(int amount) {
        this.balance -= amount;
    }

    public String getCurrency() {
        return currency;
    }
}
