package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoShopTest {

    @Test
    fun `원하는 로또 발행 방식에 맞춰서 로또를 만듭니다`() {
        val exampleLottoTicket = LottoTicket(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        val makeOneNumberLotto = DrawingMethod { exampleLottoTicket }

        val lottoShop = LottoShop()
            .installDrawingMachine(makeOneNumberLotto)

        assertThat(exampleLottoTicket == lottoShop.sellsLottoTickets(1000).lottoTickets[0])
    }
}
