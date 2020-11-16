package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class InputCheckerTest {
    @DisplayName("가격 입력시 숫자가 아닌 경우 에러 테스트")
    @Test
    fun checkPurchasePriceTest() {
        // given
        val notNumString = "a"

        // then
        assertThatThrownBy { InputChecker.checkPurchasePrice(notNumString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 입력되어야 합니다. 입력값: $notNumString")
    }

    @DisplayName("가격 입력시 1000원 미만인 경우 에러 테스트")
    @Test
    fun lottoNumCheckTest() {
        // given
        val priceNum = "900"

        // then
        assertThatThrownBy { InputChecker.checkPurchasePrice(priceNum) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 하나의 가격은 1000원입니다. 1000원 단위로 입력해주세요\n 입력값: $priceNum")
    }

    @DisplayName("입력된 가격이 숫자가 아닌 경우")
    @Test
    fun checkLottoNumTest() {
        // given
        val winnerNumsString = listOf("1", "2", "3", "4", "5", "a")

        // then
        assertThatThrownBy { InputChecker.checkWinLottoNum(winnerNumsString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자만 적어주세요 \n입력값: $winnerNumsString")
    }

    @DisplayName("양식에 맞게 6개 입력하지 않은 경우")
    @Test
    fun inputInspectTest() {
        // given
        val winnerNumsString = listOf("1", "2", "3", "4", "5")

        // then
        assertThatThrownBy { InputChecker.checkWinLottoNum(winnerNumsString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨 번호를 잘못 입력하셨습니다. \n입력값: $winnerNumsString \n개수와 띄어쓰기에 유의하여 다음과 같이 입력해주세요 : 1, 2, 5, 7, 14, 23")
    }

    @DisplayName("1~45 사이의 숫자를 입력하지 않은 경우")
    @Test
    fun checkLottoNumsTest() {
        // given
        val winnerNumsString = listOf("1", "2", "3", "4", "5", "46")

        // when
        val winnerNums = winnerNumsString.map { it.toInt() }

        // then
        assertThatThrownBy { InputChecker.checkWinLottoNum(winnerNumsString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨 번호는 1~45 사이의 숫자만 가능합니다 \n입력값: $winnerNums")
    }
}
