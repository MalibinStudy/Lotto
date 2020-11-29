package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoTicketTest {
    @Test
    fun `로또 번호가 부족한 경우 테스트`() {
        // given
        val lottoNumbers = (LottoNumber.LOTTO_START_NUMBER..5).map { LottoNumber.valueOf(it) }
        // than
        assertThatThrownBy { LottoTicket(lottoNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 반드시 ${LottoTicket.LOTTO_NUMBER_COUNT} 개 입니다.")
    }

    @Test
    fun `로또 번호가 중복인 경우 테스트`() {
        // given
        val lottoNumbers =
            (LottoNumber.LOTTO_START_NUMBER..LottoTicket.LOTTO_NUMBER_COUNT).map { LottoNumber.valueOf(1) }
        // than
        assertThatThrownBy { LottoTicket(lottoNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 중복될 수 없습니다.")
    }

    @ParameterizedTest
    @MethodSource("provideLottoTicket")
    fun `두 개의 로또 번호 비교시 matching count 테스트`(lottoTicket: LottoTicket, matchCount: Int) {
        // given
        val lastWeekWinLottoTicket = LottoTicket((1..6).map { LottoNumber.valueOf(it) })
        // than
        assertThat(lottoTicket.getLottoResultWith(lastWeekWinLottoTicket))
            .isEqualTo(matchCount)
    }

    companion object {
        @JvmStatic
        fun provideLottoTicket(): List<Arguments> {
            val arguments = mutableListOf<Arguments>()
            repeat(LottoTicket.LOTTO_NUMBER_COUNT) { repetNum ->
                arguments.add(
                    Arguments.of(
                        LottoTicket((repetNum + 1..repetNum + 6).map { LottoNumber.valueOf(it) }),
                        6 - repetNum
                    )
                )
            }
            return arguments.toList()
        }
    }
}
