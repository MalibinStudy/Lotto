package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class PurchaseInputCheckerTest {
    @DisplayName("가격 입력시 숫자가 아닌 경우 에러 테스트")
    @Test
    fun checkPurchasePriceTest() {
        // given
        val notNumString = "a"

        // then
        Assertions.assertThatThrownBy { PurchaseInputChecker().checkPurchasePrice(notNumString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 입력되어야 합니다. 입력값: $notNumString")
    }

    @DisplayName("가격 입력시 1000원 미만인 경우 에러 테스트")
    @Test
    fun lottoNumCheckTest() {
        // given
        val priceNum = "900"

        // then
        Assertions.assertThatThrownBy { PurchaseInputChecker().checkPurchasePrice(priceNum) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 하나의 가격은 1000원입니다. 1000원 이상 입력해주세요\n 입력값: $priceNum")
    }
}
