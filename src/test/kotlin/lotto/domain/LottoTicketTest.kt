package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketTest {

    @Test
    fun getMatchCount() {
        val lottoTicket = LottoTicket(listOf<Int>(3, 4, 5, 6, 7, 8))
        val winningNumbers = listOf<Int>(1, 2, 3, 5, 6, 8)
        assertThat(lottoTicket.getMatchCount(winningNumbers)).isEqualTo(4)
    }
}
