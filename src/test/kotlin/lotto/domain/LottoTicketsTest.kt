package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `보너스 번호 번호가 없는 경우  당첨 로또 티켓과 비교하는 함수가 정확한 통계를 반환하는지 테스트`() {
        // given
        var seed = 0
        val lottoTicketMachine = LottoTicketMachine {
            seed += 1
            seed
        }
        val lottoTickets = lottoTicketMachine.make(2)
        val winLottoTicket = LottoTicket(
            listOf(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(7),
                LottoNumber.create(8),
                LottoNumber.create(9),
            )

        )

        val expectedStatistics = WinLottoStatistics()
        expectedStatistics.increaseLottoCount(WinLottoTicket.THREE)
        expectedStatistics.increaseLottoCount(WinLottoTicket.THREE)

        // when
        val resultStatistics = lottoTickets.score(winLottoTicket)

        // then
        assertThat(resultStatistics).isEqualToComparingFieldByField(expectedStatistics)
    }

    @Test
    fun `보너스 번호가 있는 경우 당첨 로또티켓과 비교하는 함수가 정확한 통계를 반환하는지 테스트`() {
        // given
        var seed = 0
        val lottoTicketMachine = LottoTicketMachine {
            seed += 1
            seed
        }
        val lottoTickets = lottoTicketMachine.make(2)

        val winLottoTicket = LottoTicket(
            listOf(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(7),
                LottoNumber.create(8),
                LottoNumber.create(9),
                LottoNumber.create(10),
            )
        )
        val bonusNumber = LottoNumber.create(11)

        val expectedStatistics = WinLottoStatistics()
        expectedStatistics.increaseLottoCount(WinLottoTicket.FOUR)
        expectedStatistics.decreaseLottoCount(WinLottoTicket.FOUR)
        expectedStatistics.increaseLottoCount(WinLottoTicket.FIVE_WITH_BONUS)

        // when
        val resultStatistics = lottoTickets.score(winLottoTicket, bonusNumber)

        // then
        assertThat(resultStatistics).isEqualToComparingFieldByField(expectedStatistics)
    }
}
