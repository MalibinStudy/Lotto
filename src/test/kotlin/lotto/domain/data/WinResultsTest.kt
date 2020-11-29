package lotto.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.EnumMap

internal class WinResultsTest {
    @DisplayName("해당하는 Rank의 이익 반환 테스트")
    @Test
    fun getProfitAtTest() {
        // given
        val result = EnumMap<Rank, Int>(Rank::class.java)
        // when
        result[Rank.FIFTH] = 1
        val winResults = WinResults(result)
        // then
        assertThat(winResults.getProfitAt(Rank.FIFTH)).isEqualTo(5_000.00)
    }
}
