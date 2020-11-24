package lotto.domain

enum class LottoResult(
    val prize: Long,
    private val matchNumberStrategy: (matchCount: Int) -> Boolean
) {
    FIRST(2_000_000_000L, { matchCount -> matchCount == 6 }),
    SECOND(1_500_000L, { matchCount -> matchCount == 5 }),
    THIRD(50_000L, { matchCount -> matchCount == 4 }),
    FOURTH(5_000L, { matchCount -> matchCount == 3 }),
    LOSE(0L, { _ -> false });

    companion object {
        fun findByMatchNumOf(matchCount: Int): LottoResult {
            return values().find { it.matchNumberStrategy(matchCount) } ?: LOSE
        }
    }
}
