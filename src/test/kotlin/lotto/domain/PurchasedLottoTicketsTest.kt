package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class PurchasedLottoTicketsTest {
    @Test
    fun `size를 잘 가져오는지 테스트`() {
        // given
        val lottoTickets = LottoTicketGenerator().createAutoNumTicket()
        val purchasedLottoTickets = PurchasedLottoTickets((1..6).map { lottoTickets })
        // than
        assertThat(purchasedLottoTickets.size)
            .isEqualTo(6)
    }

    @Test
    fun `주어지는 전략으로 만들어진 로또 번호 확인`() {
        // given
        val lottoNumberGenerateStrategy =
            LottoNumberGenerateStrategy { LottoTicket((7..12).map { LottoNumber.valueOf(it) }) }
        val expectedTicket = LottoTicketGenerator.makeLottoTicket("7,8,9,10,11,12".split(","))
        // when
        val purchasedLottoTickets = LottoTicketDispenser(lottoNumberGenerateStrategy).getLottoTickets(1000L)
        // than
        assertThat(purchasedLottoTickets.toString())
            .isEqualTo(expectedTicket.toString())
    }

    @Test
    fun `지난주 당첨번호와 보너스 번호로 당첨 통계를 잘 가져오는지 테스트`() {
        // given
        val lastWeekLottoTicket = LottoTicketGenerator.makeLottoTicket("1,2,3,4,5,6".split(","))
        val lottoNumberGenerateStrategy =
            LottoNumberGenerateStrategy { LottoTicket((1..6).map { LottoNumber.valueOf(it) }) }
        val purchasedLottoTickets = LottoTicketDispenser(lottoNumberGenerateStrategy).getLottoTickets(4000L)
        // when
        val statistics = purchasedLottoTickets.getStatistics(lastWeekLottoTicket, LottoNumber.valueOf(7))
        // than
        assertThat(statistics.countWinningWith(LottoResult.FIRST))
            .isEqualTo(4)
        assertThat(statistics.getTotalPrize())
            .isEqualTo(LottoResult.FIRST.prize * 4)
    }
}
