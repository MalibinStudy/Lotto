package lotto.domain

import lotto.domain.data.Lotto
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class InputChangerTest {
    @DisplayName("가격 입력시 숫자가 아닌 경우 에러 테스트")
    @Test
    fun toMoneyTest() {
        // given
        val notNumString = "a"
        // then
        Assertions.assertThatThrownBy { InputChanger().toMoney(notNumString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 입력되어야 합니다. 입력값: $notNumString")
    }

    @Test
    fun toLottoTest() {
        // given
        val numString = "1, 2, 3, 4, 5, 6"
        // then
        assertThat(InputChanger().toLotto(numString)).isInstanceOf(Lotto::class.java)
    }

    @DisplayName("양식에 맞게 6개 입력하지 않은 경우")
    @Test
    fun checkWinnerNumsTest() {
        // given
        val winnerNumsString = "1, 2, 3, 4, 5"
        val winnerNumSplit = winnerNumsString.split(InputChanger.DELIMITER)
        // then
        Assertions.assertThatThrownBy { InputChanger().toLotto(winnerNumsString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨 번호를 잘못 입력하셨습니다. \n입력값: $winnerNumSplit \n개수와 띄어쓰기에 유의하여 다음과 같이 입력해주세요 : 1, 2, 5, 7, 14, 23")
    }
}
