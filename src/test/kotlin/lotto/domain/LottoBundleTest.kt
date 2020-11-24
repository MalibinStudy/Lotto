package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoBundleTest {
    @ParameterizedTest
    @MethodSource("providerLottoRange")
    fun `로또 전체를 체크 하는데`(range: IntRange, lottoTicket: LottoTicket) {
        val lottoBundle = LottoShop()
            .installDrawingMachine(DrawingMachine(range))
            .sellsLottoTickets(4000)

        assertThat(lottoBundle.check(lottoTicket).prizeCheckList == listOf(
            LotteryWinningCriteria.LOSING_TICKET,
            LotteryWinningCriteria.LOSING_TICKET,
            LotteryWinningCriteria.LOSING_TICKET,
            LotteryWinningCriteria.LOSING_TICKET,
        ))
    }

    companion object {
        @JvmStatic
        fun providerLottoRange() = listOf(
            Arguments.of((20..25), LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                )
            ))
        )
    }
}