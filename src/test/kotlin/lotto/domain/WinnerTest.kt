package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinnerTest {
    @ParameterizedTest
    @CsvSource("THREE,5000", "FOUR,50000", "FIVE,1500000", "SIX,2000000000")
    fun plusTest(winner: Winner, winPrice: Int) {
        // then
        assertThat(winner.winPrice).isEqualTo(winPrice)
    }
}
