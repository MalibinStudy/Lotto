package lotto.domain

import lotto.view.InputView
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputInspectorTest {
    @Test
    fun `금액이 소수점 단위로 들어오면 에러나는지 테스트`() {
        val amount = 10000
        InputView.inputMoney()

        assertThatThrownBy {
            InputInspector.checkAmountInputType(amount)
        }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("금액은 1원 단위로 입력하십시오. 입력금액: ${amount}")
    }
}
