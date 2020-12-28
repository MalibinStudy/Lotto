package lotto.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class RankTest {
    @Test
    fun `로또 번호를 5개 맞추고 보너스까지 맞출 때 2등`() {
        val lottoResult = LottoResult(5, true)
        val result = Rank.checkLottoPrize(lottoResult)

        Assertions.assertTrue(result == Rank.SECOND_PRIZE_TICKET)
    }
}
