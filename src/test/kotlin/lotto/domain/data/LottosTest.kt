package lotto.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {
    @Test
    fun resultOfWinTest() {
        // given
        val purchaseLottoNums = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(6))
        val winningLottoNums = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(6))

        // when
        val purchasedLottos = Lottos(List(1) { Lotto(purchaseLottoNums) })
        val winningLotto = Lotto(winningLottoNums)

        // then
        assertThat(purchasedLottos.resultOfWin(winningLotto).result[LottoResult.CORRECT_SIX]).isEqualTo(1)
    }
}
