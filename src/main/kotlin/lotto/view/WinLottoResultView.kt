package lotto.view

import lotto.domain.Lotto
import lotto.domain.Winner

class WinLottoResultView {
    fun showWinner(inspectResult: Map<Lotto, Int>) {
        println("\n당첨 통계\n--------")
        for (correctNum in CORRECT_THREE..CORRECT_SIX) {
            val winnerNum = inspectResult.filter { it.value == correctNum }.size
            val winner = Winner.findByCorrectNum(correctNum)
            println("${correctNum}개 일치 (${winner.winPrice}원)- ${winnerNum}개")
        }
    }

    companion object {
        const val CORRECT_THREE = 3
        const val CORRECT_SIX = 6
    }
}
