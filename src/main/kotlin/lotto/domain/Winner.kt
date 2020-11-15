package lotto.domain

enum class Winner(
    private val correctNum: Int,
    val winPrice: Int
) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    fun hasCorrectNum(correctNum: Int): Boolean {
        return this.correctNum == correctNum
    }

    companion object {
        fun findByCorrectNum(correctNum: Int): Winner {
            return values().find { it.hasCorrectNum(correctNum) }!!
        }
    }
}
