package lotto.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottosTest {
    @DisplayName("일치 개수가 알맞게 들어가는지 테스트")
    @Test
    fun resultOfWinTest() {
        // given
        val purchaseLottoNums = setOf(lottoNum(1), lottoNum(2), lottoNum(3), lottoNum(4), lottoNum(5), lottoNum(6))
        val winningLottoNums = setOf(lottoNum(1), lottoNum(2), lottoNum(3), lottoNum(4), lottoNum(5), lottoNum(6))
        val bonusNum = lottoNum(7)
        // when
        val purchasedLottos = Lottos(List(1) { Lotto(purchaseLottoNums) })
        val winningLotto = Lotto(winningLottoNums)
        // then
        assertThat(purchasedLottos.resultOfWin(winningLotto, bonusNum).result[Rank.FIRST]).isEqualTo(1)
    }

    private fun lottoNum(num: Int): LottoNum {
        return LottoNum.valueOf(num)
    }
}
