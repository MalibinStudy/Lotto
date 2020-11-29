package lotto.domain

class LottoStatistics(
    val values: Map<LottoResult, Int>
) {
    fun countWinningWith(lottoResult: LottoResult): Int = values[lottoResult] ?: 0

    fun getTotalPrize(): Long {
        return values.map { it.key.prize * it.value }.sum()
    }
}
