package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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
    fun `두 개의 로또 번호 비교시 통계 결과 테스트`(lottoTicket: LottoTicket, bonusNum: Int, result: LottoResult) {
        // given
        val lastWeekWinLottoTicket = LottoTicketGenerator.makeLottoTicket(listOf("1", "2", "3", "4", "5", "6"))
        // than
        assertThat(lottoTicket.getLottoResultWith(lastWeekWinLottoTicket, LottoNumber.valueOf(bonusNum)))
            .isEqualTo(result)
    }

    companion object {
        @JvmStatic
        fun provideLottoTicket(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    LottoTicketGenerator.makeLottoTicket(listOf("1", "2", "3", "4", "5", "6")),
                    9,
                    LottoResult.FIRST
                ),
                Arguments.of(
                    LottoTicketGenerator.makeLottoTicket(listOf("11", "2", "3", "4", "5", "6")),
                    11,
                    LottoResult.SECOND
                ),
                Arguments.of(
                    LottoTicketGenerator.makeLottoTicket(listOf("11", "2", "3", "4", "5", "6")),
                    9,
                    LottoResult.THIRD
                ),
                Arguments.of(
                    LottoTicketGenerator.makeLottoTicket(listOf("11", "12", "3", "4", "5", "6")),
                    9,
                    LottoResult.FOURTH
                ),
                Arguments.of(
                    LottoTicketGenerator.makeLottoTicket(listOf("11", "12", "13", "4", "5", "6")),
                    9,
                    LottoResult.FIFTH
                ),
            )
    }
}
