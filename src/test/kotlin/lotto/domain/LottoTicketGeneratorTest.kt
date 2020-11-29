package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class LottoTicketGeneratorTest {
    @Test
    fun `지난 주 당첨 번호가 비어있는 경우 로또 생성 테스트`() {
        // given
        val inputLastWeekLottoNumbers = "".split(",")
        // than
        assertThatThrownBy { LottoTicketGenerator().makeLottoTicket(inputLastWeekLottoNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨 번호가 숫자가 아닙니다!, 숫자가 아닌 입력된 값:")
    }

    @Test
    fun `지난주 당첨 번호에 숫자가 아닌 수가 있는 경우`() {
        // given
        val inputLastWeekLottoNumbers = "1,a,2,3,4,5".split(",")
        // than
        assertThatThrownBy { LottoTicketGenerator().makeLottoTicket(inputLastWeekLottoNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨 번호가 숫자가 아닙니다!, 숫자가 아닌 입력된 값:a")
    }

    @Test
    fun `로또 티켓 생성이 올바른지 테스트`() {
        // given
        val inputLastWeekLottoNumbers = "1,2,3,4,5,6".split(",")
        val inputLottoTicket = LottoTicket(inputLastWeekLottoNumbers.map { LottoNumber.valueOf(it.toInt()) })
        // when
        val lottoTicket = LottoTicketGenerator().makeLottoTicket(inputLastWeekLottoNumbers)
        // than
        assertThat(inputLottoTicket.getLottoResultWith(lottoTicket))
            .isEqualTo(6)
    }
}
