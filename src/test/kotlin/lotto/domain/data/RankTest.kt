package lotto.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RankTest {
    @DisplayName("correctNum과 bonusNum대로 Enum찾는 테스트")
    @ParameterizedTest
    @CsvSource(
        "0,false,MISS",
        "1,false,MISS",
        "2,false,MISS",
        "3,false,FIFTH",
        "4,false,FOURTH",
        "5,false,THIRD",
        "5,true,SECOND",
        "6,false,FIRST"
    )
    fun findTest(correctNum: Int, isBonusCorrect: Boolean, rank: Rank) {
        // then
        assertThat(Rank.find(correctNum, isBonusCorrect)).isEqualTo(rank)
    }
}
