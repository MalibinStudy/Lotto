package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoStatisticsTest {

    @ParameterizedTest
    @CsvSource("FIRST,1", "SECOND,2", "THIRD,3", "FOURTH,4")
    fun `당첨 로또 개수가 잘 나오는지 테스트`(lottoResult: LottoResult, count: Int) {
        // given
        val lottoStatistics = LottoStatistics(mapOf(lottoResult to count))
        // than
        assertThat(lottoStatistics.countWinningWith(lottoResult))
            .isEqualTo(count)
    }

    @Test
    fun `총상금 계산이 잘 되는지 테스트`() {
        // given
        val lottoStatistics = LottoStatistics(
            mapOf(
                LottoResult.SECOND to 1,
                LottoResult.FOURTH to 3
            )
        )
        val totalPrize = LottoResult.SECOND.prize + LottoResult.FOURTH.prize * 3
        // than
        assertThat(lottoStatistics.getTotalPrize())
            .isEqualTo(totalPrize)
    }
}
