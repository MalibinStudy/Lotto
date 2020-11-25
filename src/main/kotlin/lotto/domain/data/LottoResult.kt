package lotto.domain.data

enum class LottoResult(
    val correctNum: Int,
    val winPrice: Int
) {
    CORRECT_ZERO(0, 0),
    CORRECT_ONE(1, 0),
    CORRECT_TWO(2, 0),
    CORRECT_THREE(3, 5_000),
    CORRECT_FOUR(4, 50_000),
    CORRECT_FIVE(5, 1_500_000),
    CORRECT_SIX(6, 2_000_000_000);

    private fun hasCorrectNum(correctNum: Int): Boolean {
        return this.correctNum == correctNum
    }

    companion object {
        fun findByCorrectNum(correctNum: Int): LottoResult {
            return values().find { it.hasCorrectNum(correctNum) }
                ?: throw IllegalArgumentException("일치 개수가 이상해요.\n요청한 값: $correctNum")
        }
    }
}
