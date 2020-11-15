package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class LottoWinningCheckerTest {
    @Test
    fun `지난주 결과에 따라 당첨 통계가 계산되는지 확인`() {
        // given
        val lottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        )
        val lastWeekWinningNumbers = listOf(1, 2, 3, 4, 5, 45)
        // than
        assertThat(
            LottoWinningChecker(lastWeekWinningNumbers)
                .getWinningStatistics(lottoList)
                .getStatistics()[WinningStatistics.SECOND_PRIZE]
        ).isEqualTo(1)
    }
}
