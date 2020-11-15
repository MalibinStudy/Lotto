package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ValidationTest {
    @Test
    fun `입력값이 음수인 경우`() {
        val input = -5

        val UNIT_PRICE = 1000

        Assertions.assertThatThrownBy { Validation.validatePrice(price = input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("가격은 ${UNIT_PRICE}원보다 커야 합니다.")
    }

    @Test
    fun `입력 값이 한 장 가격보다 싼 경우`() {
        val input = 467

        val UNIT_PRICE = 1000

        Assertions.assertThatThrownBy { Validation.validatePrice(price = input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("가격은 ${UNIT_PRICE}원보다 커야 합니다.")
    }

    @Test
    fun `로또의 시작 숫자가 끝보다 클 떄`() {
        val start = 6
        val end = 5

        Assertions.assertThatThrownBy { Validation.validateRangeInputs(start, end) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또의 시작 범위(${start})는 끝(${end})보다 커야합니다.")
    }

    @Test
    fun `로또의 당첨 번호가 로또 길이에 맞지 않을 떄`() {
        val inputNumberList = listOf<Int>(1, 2, 3, 4)

        Assertions.assertThatThrownBy { Validation.validateWinningNumbers(inputNumberList) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨번호의 길이(${inputNumberList.size})가 " +
                    "입력하신 번호는 로또 당첨 번호가 아닙니다: 로또의 길이(${DrawingMachine.LOTTO_LENGTH})와 맞지 않습니다."
            )
    }

    @Test
    fun `로또의 당첨 번호가 정렬이 안되어 있을 때`() {
        val inputNumberList = listOf<Int>(1, 3, 2, 4, 6, 5)

        Assertions.assertThatThrownBy { Validation.validateWinningNumbers(inputNumberList) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력하신 번호는 로또 당첨 번호가 아닙니다: 정렬이 안되어 있습니다.")
    }
}
