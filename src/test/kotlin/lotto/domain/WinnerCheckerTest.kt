package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinnerCheckerTest {
    @Test
    fun getWinLottoResultTest() {
        // given
        val purchasedLottos = listOf<Lotto>()
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // then
        assertThat(WinnerChecker().getWinLottos(purchasedLottos, winningLotto))
    }

    @Test
    fun getWinLottosTest() {
        // given
        val purchasedLottos = listOf(Lotto(listOf(1, 2, 3, 4, 10, 11)))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val correctFour = WinnerChecker().getWinLottos(purchasedLottos, winningLotto)[1]

        // then
        assertThat(correctFour.getWinnerCount()).isEqualTo(1)
    }
}
