package lotto.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class LottoResultTest {
    @DisplayName("correctNum대로 Enum찾는 테스트")
    @ParameterizedTest
    @CsvSource(
        "0,CORRECT_ZERO",
        "1,CORRECT_ONE",
        "2,CORRECT_TWO",
        "3,CORRECT_THREE",
        "4,CORRECT_FOUR",
        "5,CORRECT_FIVE",
        "6,CORRECT_SIX"
    )
    fun findByCorrectNumTest(correctNum: Int, lottoResult: LottoResult) {
        // then
        assertThat(LottoResult.findByCorrectNum(correctNum)).isEqualTo(lottoResult)
    }

    @DisplayName("correctNum을 잘못 준 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["7", "-1"])
    fun findByCorrectNumTestExceptionTest(correctNum: Int) {
        // then
        assertThatThrownBy { LottoResult.findByCorrectNum(correctNum) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("일치 개수가 이상해요.\n요청한 값: $correctNum")
    }
}
