package lotto.domain

import lotto.domain.data.Money
import lotto.domain.data.LottoResult
import lotto.domain.data.WinResults
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.EnumMap

internal class ProfitCalculatorTest {
    @Test
    fun getProfitRatioTest() {
        // given
        val purchaseCost = Money(10000)
        val winLottos = EnumMap<LottoResult, Int>(LottoResult::class.java)

        // when
        winLottos[LottoResult.CORRECT_THREE] = 1
        winLottos[LottoResult.CORRECT_FOUR] = 1

        val winLottoResults = WinResults(winLottos)

        // then
        assertThat(ProfitCalculator().getProfitRatio(purchaseCost, winLottoResults)).isEqualTo(5.50)
    }
}
