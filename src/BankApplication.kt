object BankApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val nbgCard = CreditCard("John Fanidis", "€")
        val atm = ATM()

        atm.insertCard(nbgCard)
    }
}
