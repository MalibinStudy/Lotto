package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class WinningInputCheckerTest {
    @DisplayName("입력된 가격이 숫자가 아닌 경우")
    @Test
    fun checkWinLottoNumTest() {
        // given
        val winnerNumsString = listOf("1", "2", "3", "4", "5", "a")

        // then
        Assertions.assertThatThrownBy { WinningInputChecker().checkWinLottoNum(winnerNumsString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자만 적어주세요 \n입력값: $winnerNumsString")
    }

    @DisplayName("양식에 맞게 6개 입력하지 않은 경우")
    @Test
    fun inputInspectTest() {
        // given
        val winnerNumsString = listOf("1", "2", "3", "4", "5")

        // then
        Assertions.assertThatThrownBy { WinningInputChecker().checkWinLottoNum(winnerNumsString) }
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
        Assertions.assertThatThrownBy { WinningInputChecker().checkWinLottoNum(winnerNumsString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨 번호는 1~45 사이의 숫자만 가능합니다 \n입력값: $winnerNums")
    }
}
