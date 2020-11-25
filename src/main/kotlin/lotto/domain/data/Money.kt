package lotto.domain.data

data class Money(
    val value: Int
) {
    init {
        require(value >= MIN_LOTTO_PRICE) { throw IllegalArgumentException("구매 가격은 1000원 이상 입력되어야 합니다.\n입력값: $value") }
    }

    companion object {
        const val MIN_LOTTO_PRICE = 1000
    }
}
