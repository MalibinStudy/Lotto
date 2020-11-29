package lotto.domain.data

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

internal class MoneyTest {
    @DisplayName("0 이상 숫자가 아니라면 IllegalArgument 던지는지 테스트")
    @Test
    fun lottoPriceTest() {
        // then
        Assertions.assertThatThrownBy { Money(-900) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구매 가격은 0원 이상 입력되어야 합니다.\n입력값: -900")
    }

    @DisplayName("단위 금액별로 구매 개수 반환 테스트")
    @ParameterizedTest
    @CsvSource("1000,10", "500,20")
    fun getNumOfBuyTest(unitPrice: Int, result: Int) {
        // given
        val purchaseCost = 10000
        // when
        val purchaseMoney = Money(purchaseCost)
        // then
        assertThat(purchaseMoney.getNumOfBuy(unitPrice)).isEqualTo(result)
    }
}
