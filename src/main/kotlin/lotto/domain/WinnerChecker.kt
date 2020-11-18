package lotto.domain

import lotto.view.InputView

class WinnerChecker {
    private val winningNumber = InputView.winningNumberList

    fun checkEachLotto(lottoNumber: List<Int>): Int {

        val matchNumberCount = lottoNumber.filter { winningNumber!!.contains(it) }.size
        return matchNumberCount
    }

    fun checkLotteryResult(lottoList: List<List<Int>>): List<Int> {
        var prizeResult = mutableListOf<Int>()

        lottoList.forEach {
            prizeResult.add(checkEachLotto(it))
        }

        return prizeResult
    }
}
