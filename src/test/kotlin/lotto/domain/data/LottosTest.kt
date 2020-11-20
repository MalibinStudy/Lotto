package lotto.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {
    @Test
    fun getLottosTest() {
        // given
        val lottoNums = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(6))
        // when
        val lottos = Lottos(listOf(Lotto(lottoNums)))

        // then
        assertThat(lottos.getLottos().size).isEqualTo(1)
    }
}
