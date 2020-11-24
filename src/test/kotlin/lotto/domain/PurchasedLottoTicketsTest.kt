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
}
