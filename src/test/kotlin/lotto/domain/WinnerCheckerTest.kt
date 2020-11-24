package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerCheckerTest {
    @Test
    fun checkEachLottoTest(){
        val winnerChecker = WinnerChecker()
        val lottoNumber = listOf(1,2,3,4,5,6)
        val winningNumberList = listOf(3,4,5,6,7,8)

        assertThat(winnerChecker.checkEachLotto(lottoNumber, winningNumberList)).
                isEqualTo(4)
    }
    @Test
    fun checkLotteryResult() {
        val winnerChecker = WinnerChecker()
        val lottoList = listOf(listOf(1,2,3,4,5,6), listOf(5,6,7,8,9,10))
        val winningNumberList = listOf(3,4,5,6,7,8)
        val resultList = listOf(4,4)

        assertThat(winnerChecker.checkLotteryResult(lottoList, winningNumberList))
                .isEqualTo(resultList)


    }
}