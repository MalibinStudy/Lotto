package lotto.domain

import lotto.domain.data.Money
import lotto.domain.data.Rank
import lotto.domain.data.WinResults
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.EnumMap

internal class ProfitCalculatorTest {
    @Test
    fun getProfitRatioTest() {
        // given
        val purchaseCost = Money(10000)
        val winLottos = EnumMap<Rank, Int>(Rank::class.java)

        // when
        winLottos[Rank.FIFTH] = 1
        winLottos[Rank.FOURTH] = 1

        val winLottoResults = WinResults(winLottos)

        // then
        assertThat(ProfitCalculator().getProfitRatio(purchaseCost, winLottoResults)).isEqualTo(5.50)
    }
}
