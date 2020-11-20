package lotto.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class WinLottoTest {
    @DisplayName("correctNum대로 Enum찾는 테스트")
    @ParameterizedTest
    @CsvSource("3,CORRECT_THREE", "4,CORRECT_FOUR", "5,CORRECT_FIVE", "6,CORRECT_SIX")
    fun findByCorrectNumTest(correctNum: Int, winLotto: WinLotto) {
        // then
        assertThat(WinLotto.findByCorrectNum(correctNum)).isEqualTo(winLotto)
    }

    @DisplayName("correctNum을 잘못 준 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["1", "2"])
    fun findByCorrectNumTestExceptionTest(correctNum: Int) {
        // then
        assertThatThrownBy { WinLotto.findByCorrectNum(correctNum) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨 이력이 없습니다.\n요청한 값: $correctNum")
    }

    @DisplayName("WinLotto별로 correctNum 잘 가져오는지 테스트")
    @ParameterizedTest
    @CsvSource("CORRECT_THREE,3", "CORRECT_FOUR,4", "CORRECT_FIVE,5", "CORRECT_SIX,6")
    fun getCorrectNumTest(winLotto: WinLotto, correctNum: Int) {
        // then
        assertThat(winLotto.getCorrectNum()).isEqualTo(correctNum)
    }
}
