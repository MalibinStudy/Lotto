package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoResultTest {
    @ParameterizedTest
    @CsvSource("6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH", "2,LOSE", "1,LOSE")
    fun `match count에 따라 값이 잘 나오는지 테스트`(matchCount: Int, lottoResult: LottoResult) {
        // than
        assertThat(LottoResult.findByMatchNumOf(matchCount))
            .isEqualTo(lottoResult)
    }
}
