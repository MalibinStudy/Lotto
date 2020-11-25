package lotto.domain.data

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.util.EnumMap

internal class WinResultsTest {
    @DisplayName("당첨 로또가 아닐 때 Illegal 던지는지 테스트")
    @Test
    fun resultTest() {
        // given
        val result = EnumMap<LottoResult, Int>(LottoResult::class.java)
        // when
        result[LottoResult.CORRECT_ZERO] = 7
        result[LottoResult.CORRECT_ONE] = 2
        // then
        assertThatThrownBy { WinResults(result) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨 개수가 아니에요.\n $result")
    }
}
