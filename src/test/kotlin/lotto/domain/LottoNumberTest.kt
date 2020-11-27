package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @DisplayName("정수값을 넣었을 때 캐싱된 LottoNumber 객체를 반환하는지 테스트")
    @Test
    fun lottoNumberCacheTest() {
        val number = 33
        assertThat(LottoNumber.valueOf(number) == LottoNumber.valueOf(number)).isEqualTo(true)
    }

    @DisplayName("1..45사이의 값이 아닌정수를 넣었을 때 오류를 터트리는지 테스트")
    @Test
    fun checkNumberTest() {
        val number = 46
        assertThatThrownBy { LottoNumber.valueOf(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
