package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTest {
    @Test
    fun getCorrectCountToOtherTest() {
        // given
        val lottoNum = listOf(1, 2, 3, 4, 5, 6)
        val otherLottoNum = listOf(1, 2, 3, 4, 10, 11)

        // when
        val lotto = Lotto(lottoNum)
        val otherLotto = Lotto(otherLottoNum)
        // then
        assertThat(lotto.getCorrectCountToOther(otherLotto)).isEqualTo(4)
    }
}
