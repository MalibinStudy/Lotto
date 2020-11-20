package lotto.domain.data

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class MoneyTest {
    @Test
    fun getValueTest() {
        Assertions.assertThat(Money(1000).getValue()).isEqualTo(1000)
    }

    @DisplayName("1부터 45가 아니면 IllegalArgument 던지는지 테스트")
    @Test
    fun lottoNumTest() {
        // then
        Assertions.assertThatThrownBy { Money(-5000) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("돈이 이상해요 입력값: -5000")
    }
}
