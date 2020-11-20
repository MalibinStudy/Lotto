package lotto.domain

import lotto.domain.data.Money
import lotto.domain.data.WinLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.EnumMap

internal class ProfitCalculatorTest {
    @Test
    fun getProfitRatioTest() {
        // given
        val purchaseCost = Money(10000)
        val winLottos = EnumMap<WinLotto, Int>(WinLotto::class.java)

        // when
        winLottos[WinLotto.CORRECT_THREE] = 1
        winLottos[WinLotto.CORRECT_FOUR] = 1

        // then
        assertThat(ProfitCalculator().getProfitRatio(purchaseCost, winLottos)).isEqualTo(5.50)
    }
}
