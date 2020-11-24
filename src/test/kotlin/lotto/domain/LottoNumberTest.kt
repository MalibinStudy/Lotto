package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class LottoNumberTest {

    @Test
    fun `로또 번호가 지정 범위에서만 생성 되는지 확인`() {
        // than
        assertThatThrownBy { LottoNumber.valueOf(46) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 ${LottoNumber.LOTTO_START_NUMBER}~${LottoNumber.LOTTO_END_NUMBER} 사이 값이여야합니다, 입력받은 값: 46")
    }

    @Test
    fun `로또 번호에 대한 캐싱이 잘 되었는지? 새로운 객체가 나오지는 않는지 테스트`() {
        // given
        val lottonumber1 = LottoNumber.valueOf(1)
        val lottoNUmberOther1 = LottoNumber.valueOf(1)
        // than
        assertThat(lottonumber1 === lottoNUmberOther1)
            .isEqualTo(true)
    }
}
