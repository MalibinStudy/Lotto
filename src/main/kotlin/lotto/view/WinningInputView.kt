package lotto.view

import lotto.domain.InputChecker
import lotto.domain.Lotto

class WinningInputView {
    fun requestWinningLotto(): Lotto {
        println("지난주 당첨 번호를 입력해 주세요.")
        val numsString = readLine()!!
        return getWinLottoNum(numsString)
    }

    private fun getWinLottoNum(numsString: String): Lotto {
        val winnerNumsString = numsString.split(DELIMITER)
        InputChecker.checkWinLottoNum(winnerNumsString)
        val winLottoNums = winnerNumsString.map { it.toInt() }
        return Lotto(winLottoNums)
    }

    companion object {
        const val DELIMITER = ", "
    }
}
