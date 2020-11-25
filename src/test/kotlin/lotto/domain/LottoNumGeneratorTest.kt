package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoNumGeneratorTest {
    @Test
    fun generateLottoNumsTest() {
        // given
        val lottoNumGenerator = LottoNumGenerator()
        // when
        val randomNums = lottoNumGenerator.generateLottoNums()
        // then
        assertThat(randomNums.size).isEqualTo(6)
    }
}
