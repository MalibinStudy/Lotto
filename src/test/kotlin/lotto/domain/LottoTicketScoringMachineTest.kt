package lotto.domain

import lotto.domain.LottoScoringMachine.scoreLottoTickets
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.EnumMap

class LottoTicketScoringMachineTest {
    @Test
    fun `로또티켓 여러개의 당첨 통계 만드는 함수 테스트`() {
        // given
        val lottoTicketMachine = LottoTicketMachine { 1 }
        val lottoTicket = lottoTicketMachine.make()

        val lottoNumOne = LottoNumCache.getLottoNum(1)
        val lottoNumTwo = LottoNumCache.getLottoNum(2)
        val lottoNumThree = LottoNumCache.getLottoNum(3)

        val winLottoTicket = LottoTicket(
            listOf(
                lottoNumOne,
                lottoNumTwo,
                lottoNumOne,
                lottoNumOne,
                lottoNumThree,
                lottoNumTwo
            )
        )

        val expectedLottoScore = WinLottoStatistics(
            EnumMap<WinLottoTicket, Int>(WinLottoTicket::class.java)
        )
        expectedLottoScore.increaseLottoCount(
            WinLottoTicket.findInstance(3)
        )

        // when
        val lottoScore = scoreLottoTickets(winLottoTicket, listOf(lottoTicket))

        // then
        assertThat(lottoScore).isEqualToComparingFieldByField(expectedLottoScore)
    }
}
