package lotto.domain.data

import java.util.EnumMap

data class Lottos(
    val lottos: List<Lotto>
) {
    fun resultOfWin(winningLotto: Lotto, bonusNum: LottoNum): WinResults {
        val results = EnumMap<Rank, Int>(Rank::class.java)
        results[Rank.FIRST] = lottos.count { it.getWinnerByCompare(winningLotto, bonusNum) == Rank.FIRST }
        results[Rank.SECOND] =
            lottos.count { it.getWinnerByCompare(winningLotto, bonusNum) == Rank.SECOND }
        results[Rank.THIRD] =
            lottos.count { it.getWinnerByCompare(winningLotto, bonusNum) == Rank.THIRD }
        results[Rank.FOURTH] = lottos.count { it.getWinnerByCompare(winningLotto, bonusNum) == Rank.FOURTH }
        results[Rank.FIFTH] = lottos.count { it.getWinnerByCompare(winningLotto, bonusNum) == Rank.FIFTH }
        return WinResults(results)
    }
}
