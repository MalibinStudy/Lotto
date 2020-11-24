package lotto.domain

import lotto.view.InputView

class WinnerChecker {

    fun checkEachLotto(lottoNumber: List<Int>, winningNumberList: List<Int>): Int {

        val matchNumberCount = lottoNumber.filter { winningNumberList!!.contains(it) }.size
        return matchNumberCount
    }

    fun checkLotteryResult(lottoList: List<List<Int>>, winningNumberList: List<Int>): List<Int> {
        return lottoList.map { checkEachLotto(it,winningNumberList) }
    }
}
