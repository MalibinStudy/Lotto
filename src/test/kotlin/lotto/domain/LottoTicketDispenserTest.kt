package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketDispenserTest {
    @Test
    fun `주어진 금액에 맞게 로또의 구입이 되는지 확인`() {
        // given
        val inputMoeny = 10000L
        // than
        assertThat(LottoTicketDispenser(LottoTicketGenerator()).getLottoTickets(inputMoeny).size)
            .isEqualTo(inputMoeny / LottoTicket.LOTTO_PRICE)
    }

    @Test
    fun `주어지는 전략으로 만들어진 로또 번호 확인`() {
        // given
        val lottoNumberGenerateStrategy =
            LottoNumberGenerateStrategy { LottoTicket((7..12).map { LottoNumber.valueOf(it) }) }
        val expectedTicket = LottoTicketGenerator().makeLottoTicket("7,8,9,10,11,12".split(","))
        // when
        val purchasedLottoTickets = LottoTicketDispenser(lottoNumberGenerateStrategy).getLottoTickets(1000L)
        // than
        assertThat(purchasedLottoTickets.lottoTickets[0].toString())
            .isEqualTo(expectedTicket.toString())
    }
}
