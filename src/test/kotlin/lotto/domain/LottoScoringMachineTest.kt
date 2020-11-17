package lotto.domain

import lotto.domain.LottoScoringMachine.scoreLottos
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoScoringMachineTest {
    @Test
    fun `당첨 통계 만드는 함수 테스트`() {
        // given
        val lotto = listOf(
            Lotto(listOf(2, 4, 6, 8, 10, 12)),
            Lotto(listOf(1, 3, 5, 7, 9, 6))
        )
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val lottoScore = scoreLottos(winLotto, lotto)
        val expectedLottoScore = WinLottoScore(
            mutableMapOf(
                WinLotto.THREE to 1,
                WinLotto.FOUR to 1,
                WinLotto.FIVE to 0,
                WinLotto.SIX to 0
            )
        )
        assertThat(lottoScore).isEqualToComparingFieldByField(expectedLottoScore)
    }
}
