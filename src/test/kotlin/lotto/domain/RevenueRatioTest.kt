package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import java.math.RoundingMode

internal class RevenueRatioTest {
    @Test
    fun `수익률 계산이 정확하게 이루어지는지 테스트`() {
        // given
        val money = 14_000L
        val result = 5_000L
        // when
        val expectedRevenueRatio = result.toBigDecimal().divide(money.toBigDecimal(), 2, RoundingMode.HALF_DOWN)
        // than
        assertThat(RevenueRatio.calculate(money, result))
            .isEqualTo(expectedRevenueRatio)
    }
}
