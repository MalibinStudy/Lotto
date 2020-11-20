package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoNumGeneratorTest {
    @Test
    fun generateRandomNumsTest() {
        // given
        val lottoNumGenerator = LottoNumGenerator()
        // when
        val randomNums = lottoNumGenerator.generateRandomNums()
        // then
        randomNums.forEach {
            assertThat(it.getLottoNum()).isLessThan(46)
            assertThat(it.getLottoNum()).isGreaterThan(0)
        }
    }
}
