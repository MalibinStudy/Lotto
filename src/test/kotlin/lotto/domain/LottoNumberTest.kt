package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호가 지정 범위에서만 생성 되는지 확인`(notRangeLottoNum: Int) {
        // than
        assertThatThrownBy { LottoNumber.valueOf(notRangeLottoNum) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 ${LottoNumber.LOTTO_START_NUMBER} ~ ${LottoNumber.LOTTO_END_NUMBER} 사이 값이여야합니다, 입력받은 값: $notRangeLottoNum")
    }

    @Test
    fun `로또 번호에 대한 캐싱이 잘 되었는지? 새로운 객체가 나오지는 않는지 테스트`() {
        // given
        val lottonumber1 = LottoNumber.valueOf(1)
        val lottoNUmberOther1 = LottoNumber.valueOf(1)
        // than
        assertThat(lottonumber1 == lottoNUmberOther1)
            .isEqualTo(true)
    }

    @ParameterizedTest
    @CsvSource("1,2,false", "1,1,true")
    fun `두 로또 번호 비교 테스트`(num: Int, otherNum: Int, result: Boolean) {
        // given
        val lottoNumber = LottoNumber.valueOf(num)
        val otherLottoNumber = LottoNumber.valueOf(otherNum)
        // than
        assertThat(lottoNumber == otherLottoNumber)
            .isEqualTo(result)
    }
}
