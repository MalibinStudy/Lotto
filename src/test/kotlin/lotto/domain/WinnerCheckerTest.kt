package lotto.domain

import lotto.domain.data.Money
import lotto.domain.data.Lotto
import lotto.domain.data.Lottos
import lotto.domain.data.WinLotto
import lotto.domain.data.LottoNum
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinnerCheckerTest {
    @Test
    fun getWinLottosTest() {
        // given
        val lottoNumGenerator = LottoNumGenerator()
        val lottoMachine = LottoMachine(lottoNumGenerator)
        val winningLottoNums = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(6))

        // when
        val purchasedLottos = lottoMachine.generatedLottos(Money(30000))
        val winningLotto = Lotto(winningLottoNums)

        // then
        assertThat(WinnerChecker().getWinLottos(purchasedLottos, winningLotto).size).isEqualTo(4)
    }

    @Test
    fun getWinLottoResultTest() {
        // given
        val purchaseLottoNums = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(6))
        val winningLottoNums = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(6))

        // when
        val purchasedLottos = Lottos(List(1) { Lotto(purchaseLottoNums) })
        val winningLotto = Lotto(winningLottoNums)

        // then
        assertThat(WinnerChecker().getWinLottos(purchasedLottos, winningLotto)[WinLotto.CORRECT_SIX]).isEqualTo(1)
    }
}
