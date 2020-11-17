package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinLottoScoreTest {
    @Test
    fun `이윤율을 계산하는 함수가 정확한 값을 반환하는지 테스트`() {
        // given
        val money = 10000
        val lottoScore = WinLottoScore(
            mutableMapOf(
                WinLotto.THREE to 1,
                WinLotto.FOUR to 2,
                WinLotto.FIVE to 0,
                WinLotto.SIX to 0
            )
        )

        // when
        val profitRate = lottoScore.getProfitRate(money)

        // then
        assertThat(profitRate).isEqualTo(10.5)
    }
}
