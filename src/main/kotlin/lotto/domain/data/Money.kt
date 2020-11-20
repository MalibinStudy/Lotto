package lotto.domain.data

data class Money(
    private val value: Int
) {
    init {
        require(value > 0) { "돈이 이상해요 입력값: $value" }
    }

    fun getValue(): Int {
        return this.value
    }
}
