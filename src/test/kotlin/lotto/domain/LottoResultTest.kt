package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoResultTest {
    @ParameterizedTest
    @CsvSource(
        "6,FIRST,false",
        "5,SECOND,true",
        "5,THIRD,false",
        "4,FOURTH,false",
        "3,FIFTH,false",
        "2,LOSE,false",
        "1,LOSE,false"
    )
    fun `match count, 보너스 번호에 따라 값이 잘 나오는지 테스트`(matchCount: Int, lottoResult: LottoResult, isBonusMatched: Boolean) {
        // than
        assertThat(LottoResult.findByMatchNumOf(matchCount, isBonusMatched))
            .isEqualTo(lottoResult)
    }
}
