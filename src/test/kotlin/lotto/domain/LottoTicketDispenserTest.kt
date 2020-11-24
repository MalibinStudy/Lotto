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
}
