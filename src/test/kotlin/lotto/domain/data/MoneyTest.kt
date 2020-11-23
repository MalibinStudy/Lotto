package lotto.domain.data

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class MoneyTest {
    @DisplayName("1000 이상 숫자가 아니라면 IllegalArgument 던지는지 테스트")
    @Test
    fun lottoPriceTest() {
        // then
        Assertions.assertThatThrownBy { Money(900) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구매 가격은 1000원 이상 입력되어야 합니다.\n입력값: 900")
    }
}
