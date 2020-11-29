package lotto.domain.data

data class Money(
    val value: Int
) {
    init {
        require(value >= MIN_MONEY) { throw IllegalArgumentException("구매 가격은 0원 이상 입력되어야 합니다.\n입력값: $value") }
    }

    fun getNumOfBuy(unitPrice: Int): Int {
        return value / unitPrice
    }

    companion object {
        const val MIN_MONEY = 0
    }
}
