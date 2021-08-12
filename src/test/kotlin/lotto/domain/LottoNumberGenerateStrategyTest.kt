package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class LottoNumberGenerateStrategyTest {
    @Test
    fun `주어진 번호로 로또 티켓을 만들 수 있는지 테스트`() {
        // given
        val expectedTicket = LottoTicketGenerator.makeLottoTicket(listOf("1", "2", "3", "4", "5", "6"))
        val lottoNumberGenerateStrategy =
            LottoNumberGenerateStrategy { LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.valueOf(it) }) }
        // than
        assertThat(lottoNumberGenerateStrategy.createAutoNumTicket().toString())
            .isEqualTo(expectedTicket.toString())
    }
}
