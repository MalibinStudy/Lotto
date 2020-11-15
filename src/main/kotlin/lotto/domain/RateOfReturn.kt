package lotto.domain

object RateOfReturn {
    fun get(amount: Int, totalPrizeMoney: Double): Double {
        return (totalPrizeMoney / amount)
    }
}
