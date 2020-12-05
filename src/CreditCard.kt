import java.util.concurrent.ThreadLocalRandom

class CreditCard(val customerName: String, val currency: String) {
    var balance = 0
    val creditCardNumber: Int = ThreadLocalRandom.current().nextInt(100000000, 999999999)

    fun addBalance(amount: Int) {
        balance += amount
    }

    fun removeBalance(amount: Int) {
        balance -= amount
    }

}
