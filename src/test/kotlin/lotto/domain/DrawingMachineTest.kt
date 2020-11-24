package lotto.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class DrawingMachineTest {
    @Test
    fun `정해둔 범위 이내에서 로또 티켓을 만들어냅니다`() {
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
        val exampleRange = 1..6
        val lottoShop = LottoShop()
            .installDrawingMachine(DrawingMachine(exampleRange))

        assertTrue(
            lottoShop
                .sellsLottoTickets(1000)
                .lottoTickets[0]
                .check(exampleLottoTicket) == 6
        )
    }
}
