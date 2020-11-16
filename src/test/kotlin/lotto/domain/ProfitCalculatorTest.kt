package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfitCalculatorTest {
    @Test
    fun getProfitRatioTest() {
        // given
        val inputPrice = 10000
        val outputPrice = 55000.00

        // then
        assertThat(ProfitCalculator().getProfitRatio(inputPrice, outputPrice)).isEqualTo(5.50)
    }

    @Test
    fun getTotalProfitTest() {
        // given
        val winLottos =
            listOf(WinLotto.CORRECT_THREE, WinLotto.CORRECT_FOUR, WinLotto.CORRECT_FIVE, WinLotto.CORRECT_SIX)
        // when
        winLottos[0].setWinnerCount(1)
        winLottos[1].setWinnerCount(1)
        // then
        assertThat(ProfitCalculator().getTotalProfit(winLottos)).isEqualTo(55000.0)
    }
}
