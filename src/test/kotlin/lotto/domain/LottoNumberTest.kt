package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoNumberTest {
    @ParameterizedTest
    @CsvSource("46", "80", "75", "55", "78")
    fun `범위에 있지 않으면 Exception을 터뜨립니다`(input: Int) {
        Assertions.assertThatThrownBy { LottoNumber(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력한 숫자는 로또 번호에 해당하지 않습니다. 입력한 번호: $input")
    }
}
