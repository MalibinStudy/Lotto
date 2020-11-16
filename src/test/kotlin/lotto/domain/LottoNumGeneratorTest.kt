package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoNumGeneratorTest {
    @Test
    fun generateRandomNumsTest() {
        // when
        val randomNums = LottoNumGenerator.getGeneratedLottoNums()
        // then
        randomNums.forEach {
            assertThat(it).isLessThan(46)
            assertThat(it).isGreaterThan(0)
        }
    }

    @Test
    fun getGeneratedLottoNumsTest() {
        // when
        val randomNums = LottoNumGenerator.getGeneratedLottoNums()
        // then
        assertThat(randomNums.size).isEqualTo(6)
    }
}
