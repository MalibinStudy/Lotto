package lotto.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class LottoNumTest {
    @Test
    fun getLottoNumTest() {
        assertThat(LottoNum(29).getLottoNum()).isEqualTo(29)
    }

    @DisplayName("1부터 45가 아니면 IllegalArgument 던지는지 테스트")
    @Test
    fun lottoNumTest() {
        // then
        assertThatThrownBy { LottoNum(50) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자만 가능합니다. 현재 값: 50")
    }
}
