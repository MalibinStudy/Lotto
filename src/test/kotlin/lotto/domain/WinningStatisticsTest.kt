package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class WinningStatisticsTest {
    @Test
    fun `당첨된 숫자 개수에 따라 해당 상금 카운팅이 되는지 테스트`() {
        // given
        val winningStatistics = WinningStatistics()
        val testStatistics = mapOf<Int, Int>(
            WinningStatistics.FIRST_PRIZE to 1
        )
        // when
        winningStatistics.increase(6)
        // than
        assertThat(winningStatistics.getStatistics()[WinningStatistics.FIRST_PRIZE])
            .isEqualTo(testStatistics[WinningStatistics.FIRST_PRIZE])
    }
}
