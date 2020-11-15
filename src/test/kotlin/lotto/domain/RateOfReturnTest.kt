package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

internal class RateOfReturnTest {
    @ParameterizedTest
    @CsvSource("3,5000.0", "4,50000.0", "5,1500000.0", "6,2000000000.0")
    fun `수익률 계산이 잘 되는지 확인`(matchNumerCount: Int, totalPrizeNumber: Double) {
        // given
        val winningStatistics = WinningStatistics()
        // when
        winningStatistics.increase(matchNumerCount)

        // than
        assertThat(RateOfReturn.get(1000, winningStatistics.getTotalPrize()))
            .isEqualTo(
                (totalPrizeNumber / 1000).toBigDecimal().setScale(2, BigDecimal.ROUND_DOWN).toDouble()
            )
    }
}
