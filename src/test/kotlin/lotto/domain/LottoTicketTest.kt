package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `입력 Lotto과 몇개의 공통된 숫자를 갖는지 계산하는 함수 테스트 `() {
        // given
        val lottoFirstNumber = LottoNumber.create(1)
        val lottoSecondNumber = LottoNumber.create(2)
        val lottoThirdNumber = LottoNumber.create(3)
        val lottoFourthNumber = LottoNumber.create(4)
        val lottoFifthNumber = LottoNumber.create(5)
        val lottoSixthNumber = LottoNumber.create(6)
        val lottoSeventhNumber = LottoNumber.create(7)

        val lottoTicket = LottoTicket(
            listOf(
                lottoFirstNumber,
                lottoSecondNumber,
                lottoThirdNumber,
                lottoFourthNumber,
                lottoFifthNumber,
                lottoSixthNumber
            )
        )

        val otherLottoTicket = LottoTicket(
            listOf(
                lottoSecondNumber,
                lottoThirdNumber,
                lottoFourthNumber,
                lottoFifthNumber,
                lottoSixthNumber,
                lottoSeventhNumber
            )
        )

        // when
        val result = lottoTicket.countSameNumber(otherLottoTicket)
        lottoTicket.toString()

        // then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `중복된 숫자를 갖지 못하는지 테스트`() {
        // given
        val lottoSameNumber1 = LottoNumber.create(1)
        val lottoSameNumber2 = LottoNumber.create(1)
        val lottoThirdNumber = LottoNumber.create(2)
        val lottoFourthNumber = LottoNumber.create(3)
        val lottoFifthNumber = LottoNumber.create(4)
        val lottoSixthNumber = LottoNumber.create(5)

        val lottoNumbers = listOf(
            lottoSameNumber1,
            lottoSameNumber2,
            lottoThirdNumber,
            lottoFourthNumber,
            lottoFifthNumber,
            lottoSixthNumber
        )

        // then
        assertThatThrownBy { LottoTicket(lottoNumbers) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 숫자는 중복될 수 없습니다.")
    }

    @Test
    fun `로또 숫자가 6개보다 작으면 에러를 발생하는지 테스트`() {
        // given
        val lottoFirstNumber = LottoNumber.create(1)
        val lottoSecondNumber = LottoNumber.create(2)
        val lottoThirdNumber = LottoNumber.create(3)
        val lottoFourthNumber = LottoNumber.create(4)
        val lottoFifthNumber = LottoNumber.create(5)

        val lottoNumbers = listOf(
            lottoFirstNumber,
            lottoSecondNumber,
            lottoThirdNumber,
            lottoFourthNumber,
            lottoFifthNumber
        )

        // then
        assertThatThrownBy { LottoTicket(lottoNumbers) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 숫자는 총 6개입니다.")
    }

    @Test
    fun `로또 숫자가 6개보다 크면 에러를 발생하는지 테스트`() {
        // given
        val lottoFirstNumber = LottoNumber.create(1)
        val lottoSecondNumber = LottoNumber.create(2)
        val lottoThirdNumber = LottoNumber.create(3)
        val lottoFourthNumber = LottoNumber.create(4)
        val lottoFifthNumber = LottoNumber.create(5)
        val lottoSixthNumber = LottoNumber.create(6)
        val lottoSeventhNumber = LottoNumber.create(7)

        val lottoNumbers = listOf(
            lottoFirstNumber,
            lottoSecondNumber,
            lottoThirdNumber,
            lottoFourthNumber,
            lottoFifthNumber,
            lottoSixthNumber,
            lottoSeventhNumber
        )

        // then
        assertThatThrownBy { LottoTicket(lottoNumbers) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 숫자는 총 6개입니다.")
    }
}
