package lotto.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoNumTest {
    @DisplayName("해당 숫자의 LottoNum객체를 던지는지 테스트")
    @Test
    fun valueOfTest() {
        // then
        assertThat(LottoNum.valueOf(15)).isInstanceOf(LottoNum::class.java)
    }
}
