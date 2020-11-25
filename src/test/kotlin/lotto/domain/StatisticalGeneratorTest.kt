package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class StatisticalGeneratorTest {
    @Test
    fun `지난 주 당첨 번호와 티켓들을 비교했을때 결과가 잘 나오는지 확인`() {
        // given
        val lastWeekLottoTicket = LottoTicketGenerator().makeLottoTicket("1,2,3,4,5,6".split(","))
        val lottoStatisticsGenerator = StatisticalGenerator(createLottoTickets())
        // when
        val statistics = lottoStatisticsGenerator.getStatisticsUse(lastWeekLottoTicket)
        // than
        assertThat(statistics.countWinningWith(LottoResult.FIRST))
            .isEqualTo(4)
        assertThat(statistics.getTotalPrize())
            .isEqualTo(LottoResult.FIRST.prize * 4)
    }

    private fun createLottoTickets(): PurchasedLottoTickets {
        return LottoTicketDispenser {
            LottoTicket((1..6).map { LottoNumber.valueOf(it) })
        }.getLottoTickets(4000)
    }
}
