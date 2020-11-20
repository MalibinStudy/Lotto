package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.Lottos
import lotto.domain.data.WinLotto
import java.util.EnumMap

class WinnerChecker {
    fun getWinLottos(purchasedLottos: Lottos, winningLotto: Lotto): EnumMap<WinLotto, Int> {
        val winLottos = purchasedLottos.getLottos()
            .mapNotNull { it.getWinnerByCompare(winningLotto) }
        return getWinLottoResult(winLottos)
    }

    private fun getWinLottoResult(winLottos: List<WinLotto>): EnumMap<WinLotto, Int> {
        val winLottoResult = EnumMap<WinLotto, Int>(WinLotto::class.java)
        winLottoResult[WinLotto.CORRECT_THREE] = winLottos.count { it.getCorrectNum() == 3 }
        winLottoResult[WinLotto.CORRECT_FOUR] = winLottos.count { it.getCorrectNum() == 4 }
        winLottoResult[WinLotto.CORRECT_FIVE] = winLottos.count { it.getCorrectNum() == 5 }
        winLottoResult[WinLotto.CORRECT_SIX] = winLottos.count { it.getCorrectNum() == 6 }
        return winLottoResult
    }
}
