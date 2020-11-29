package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoNumberTest {
    @ParameterizedTest
    @CsvSource("-1, 46")
    fun `LottoNumber 범위 외의 숫자가 들어갈 수 없도록 하는지 테스트`(number: Int) {
        // then
        assertThatThrownBy { LottoNumber.create(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 숫자는 1에서 45사이의 숫자입니다.")
    }
}
