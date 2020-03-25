import kotlin.math.round

fun main() {
    // Примеры вызова функции
    formatPrice(119.0, "кг", 5)
    formatPrice(112.1, "мл", 5)
    formatPrice(119.9, "км", 5)
    formatPrice(119.0)
}

fun formatPrice(price: Double, measure: String = "шт", discount: Int = 0) {
    println("${calcDiscount(price, discount)}/$measure ${if (discount != 0) "(скидка $discount%)" else ""}")
}

fun calcDiscount(price: Double, discount: Int): String {
    val discountPrice = price * (1 - discount / 100.0)
    return if (discountPrice - discountPrice.toInt() == 0.0) "${discountPrice.toInt()}"
            else "${round(discountPrice * 100) / 100}"
             // Для вывода c округлением "%.2f".format(Locale.US, discountPrice)
}
