import java.util.*

internal class ATM {
    private var creditCard: CreditCard? = null
    private var previousTransaction = 0
    private val scanner = Scanner(System.`in`)

    private fun depositMoney(amount: Int) {
        if (amount != 0) {
            creditCard!!.addBalance(amount)
            previousTransaction = amount
        }
    }

    private fun withdrawMoney(amount: Int) {
        if (amount != 0) {
            creditCard!!.removeBalance(amount)
            previousTransaction = amount
        }
    }

    private fun showPreviousTransaction() {
        if (previousTransaction > 0) {
            println("Deposited: " + previousTransaction + creditCard!!.currency)
        } else if (previousTransaction < 0) {
            println("Withdrawn: " + Math.abs(previousTransaction) + creditCard!!.currency)
        } else {
            println("No transaction available")
        }
    }

    private fun showCustomerBalance() {
        println("\n")
        println("============================")
        println("Your current balance is " + creditCard!!.balance + creditCard!!.currency)
        println("============================")
    }

    private fun showWelcomeMessage() {
        println("Welcome " + creditCard!!.customerName)
        println("Your card number is " + creditCard!!.creditCardNumber)
        println("\n")
    }

    private fun showAvailableTransactions() {
        println("======================")
        println("Available transactions")
        println("======================")
        println("1. Check balance")
        println("2. Deposit")
        println("3. Withdraw")
        println("4. Previous transaction")
        println("5. Exit")
        println("==========================")
        print("Enter transaction code: ")
    }

    private fun showGoodbyeMessage() {
        println("===============================================")
        println("Thank you dear customer. Hope to see you again!")
        println("===============================================")
    }

    fun insertCard(card: CreditCard?) {
        creditCard = card
        var transactionCode: Char

        showWelcomeMessage()

        do {
            showAvailableTransactions()

            transactionCode = scanner.next()[0]
            when (transactionCode) {
                '1' -> {
                    showCustomerBalance()
                }
                '2' -> {
                    print("Enter deposit amount: ")
                    val depositAmount = scanner.nextInt()
                    depositMoney(depositAmount)
                    showCustomerBalance()
                }
                '3' -> {
                    print("Enter withdraw amount: ")
                    val withdrawAmount = scanner.nextInt()
                    withdrawMoney(withdrawAmount)
                    showCustomerBalance()
                }
                '4' -> {
                    showPreviousTransaction()
                }
                else -> {
                }
            }
            println("\n")
        } while (transactionCode != '5')

        showGoodbyeMessage()
    }
}
