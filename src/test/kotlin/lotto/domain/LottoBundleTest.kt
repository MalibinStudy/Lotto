package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoBundleTest {
    @ParameterizedTest
    @MethodSource("providerLottoRange")
    fun `로또 전체를 체크 하는데`(range: IntRange, lottoTicket: LottoTicket) {
        val myLottoMachine = DrawingMethod {
            LottoTicket(
                range.shuffled()
                    .take(7)
                    .map { LottoNumber.from(it) }
                    .sortedBy { it.lottoNumber }
            )
        }
        val lottoBundle = LottoShop(myLottoMachine).sellsLottoTickets(4000)

        assertThat(
            lottoBundle.check(lottoTicket).prizeCheckList == listOf(
                Rank.LOSING_TICKET,
                Rank.LOSING_TICKET,
                Rank.LOSING_TICKET,
                Rank.LOSING_TICKET,
            )
        )
    }

    companion object {
        @JvmStatic
        fun providerLottoRange() = listOf(
            Arguments.of(
                (20..26),
                LottoTicket(
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
            )
        )
    }
}
