package lotto.domain.data

import java.util.EnumMap

data class Lottos(
    val lottos: List<Lotto>
) {
    fun resultOfWin(winningLotto: Lotto): WinResults {
        val results = EnumMap<LottoResult, Int>(LottoResult::class.java)
        results[LottoResult.CORRECT_THREE] = lottos.count { it.getWinnerByCompare(winningLotto).correctNum == 3 }
        results[LottoResult.CORRECT_FOUR] = lottos.count { it.getWinnerByCompare(winningLotto).correctNum == 4 }
        results[LottoResult.CORRECT_FIVE] = lottos.count { it.getWinnerByCompare(winningLotto).correctNum == 5 }
        results[LottoResult.CORRECT_SIX] = lottos.count { it.getWinnerByCompare(winningLotto).correctNum == 6 }
        return WinResults(results)
    }
}
