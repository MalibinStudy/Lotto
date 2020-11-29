package lotto.domain

import lotto.domain.LottoTicket.Companion.LOTTO_LENGTH
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class LottoShopTest {

    @Test
    fun `원하는 로또 발행 방식에 맞춰서 로또를 만듭니다`() {
        val exampleLottoTicket = LottoTicket(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
                LottoNumber.from(7),
            )
        )

        val makeOneNumberLotto = DrawingMethod { exampleLottoTicket }

        val lottoShop = LottoShop(makeOneNumberLotto)

        assertThat(exampleLottoTicket == lottoShop.sellsLottoTickets(1000).lottoTickets[0])
    }

    @Test
    fun `정해둔 범위 이내에서 로또 티켓을 만들어냅니다`() {
        val exampleLottoTicket = LottoTicket(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
                LottoNumber.from(7),
            )
        )
        val exampleRange = 1..7
        val myDrawingMachine = DrawingMethod {
            LottoTicket(
                exampleRange.map { LottoNumber.from(it) }
                    .shuffled()
                    .take(LottoTicket.LOTTO_LENGTH)
                    .sortedBy { it.lottoNumber }
            )
        }
        val lottoShop = LottoShop(myDrawingMachine)

        Assertions.assertTrue(
            lottoShop
                .sellsLottoTickets(1000)
                .lottoTickets[0]
                .check(exampleLottoTicket).matchCount == LOTTO_LENGTH - 1
        )
    }
}
