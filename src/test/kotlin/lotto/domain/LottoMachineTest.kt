package lotto.domain

import lotto.domain.LottoTicket.Companion.LOTTO_LENGTH
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class LottoMachineTest {
    @Test
    fun `로또 추첨기에서 나오는 로또는 길이가 7입니다`() {
        val lottoMachine = LottoMachine()
        val lotto = lottoMachine.getLottoTicket()

        Assertions.assertThat(
            lotto.lottoTicket
                .size == LOTTO_LENGTH
        ).isTrue
    }

    @Test
    fun `로또의 초반 당첨 숫자 6개는 정렬된 순서로 나옵니다`() {
        val lottoMachine = LottoMachine()
        val lotto = lottoMachine.getLottoTicket()
        val winningNumbers = lotto.lottoTicket.take(LOTTO_LENGTH - 1)
        val sortedWinningNumber = winningNumbers.sortedBy { it.lottoNumber }

        Assertions.assertThat(
            winningNumbers.zip(sortedWinningNumber)
                .all { (notSorted, sorted) -> notSorted == sorted }
        ).isTrue
    }
}
