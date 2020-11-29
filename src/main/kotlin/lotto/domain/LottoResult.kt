package lotto.domain

enum class LottoResult(
    val prize: Long,
    private val matchNumberStrategy: (matchCount: Int, isBonusMatched: Boolean) -> Boolean
) {
    FIRST(2_000_000_000L, { matchCount, _ -> matchCount == 6 }),
    SECOND(30_000_000L, { matchCount, isBonusMatched -> matchCount == 5 && isBonusMatched }),
    THIRD(1_500_000L, { matchCount, isBonusMatched -> matchCount == 5 && !isBonusMatched }),
    FOURTH(50_000L, { matchCount, _ -> matchCount == 4 }),
    FIFTH(5_000L, { matchCount, _ -> matchCount == 3 }),
    LOSE(0L, { _, _ -> false });

    companion object {
        fun findByMatchNumOf(matchCount: Int, matchBonus: Boolean): LottoResult {
            return values().find { it.matchNumberStrategy(matchCount, matchBonus) } ?: LOSE
        }
    }
}
