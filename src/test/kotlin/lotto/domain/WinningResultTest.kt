package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

internal class WinningResultTest {

    @ParameterizedTest
    @CsvSource("EQUAL_FIVE,1500000", "EQUAL_TWO,0")
    fun getPrizeTest(winningResult: WinningResult, prize: Int) {
        assertThat(winningResult.prize).isEqualTo(prize)
    }

    @DisplayName("일치 개수를 잘못 입력하였을 때 오류가 나는지 테스트")
    @Test
    fun findByEqualCountErrorTest() {
        val equalCount = 7
        assertThatThrownBy { WinningResult.findByEqualCount(equalCount) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource("5,EQUAL_FIVE", "0,EQUAL_ZERO", "6,EQUAL_SIX")
    fun findByEqualCountTest(equalCount: Int, winningResult: WinningResult) {
        assertThat(WinningResult.findByEqualCount(equalCount))
            .isEqualTo(winningResult)
    }
}
