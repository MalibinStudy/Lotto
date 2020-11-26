package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.EnumMap

class WinLottoStatisticsTest {
    @Test
    fun `이윤율을 계산하는 함수가 정확한 값을 반환하는지 테스트`() {
        // given
        val money = Money(10000)
        val lottoScore = WinLottoStatistics(
            EnumMap<WinLottoTicket, Int>(
                WinLottoTicket::class.java
            )
        )
        lottoScore.increaseLottoCount(
            WinLottoTicket.findInstance(3)
        )

        // when
        val profitRate = lottoScore.getProfitRate(money)

        // then
        assertThat(profitRate).isEqualTo(0.5)
    }
}
