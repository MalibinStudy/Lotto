package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PrizeCalculatorTest {
    @Test
    fun getPrizeMoneySum() {
        assertThat(PrizeCalculator.getPrizeMoneySum(listOf(1, 1, 2, 3, 6)))
            .isEqualTo(2000005000)
    }
}
