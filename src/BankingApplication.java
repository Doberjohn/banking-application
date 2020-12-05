public class BankingApplication {

    public static void main(String[] args) {
        CreditCard creditCard1 = new CreditCard("John Fanidis", "€");
        ATM atm = new ATM();
        atm.insertCard(creditCard1);
    }
}
