public class BankApplication {

    public static void main(String[] args) {
        CreditCard nbgCard = new CreditCard("John Fanidis", "€");

        ATM atm = new ATM();
        atm.insertCard(nbgCard);
    }
}
