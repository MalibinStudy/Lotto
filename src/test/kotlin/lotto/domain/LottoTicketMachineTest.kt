package lotto.domain

import lotto.domain.LottoNum.Companion.LOTTO_NUM_RANGE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketMachineTest {
    val lottoTicketMachine = LottoTicketMachine { 1 }

    @Test
    fun `로또 티켓을 만드는 make함수가 1에서 45사이의 로또 번호를 가지는 티켓을 반환하는지 테스트`() {
        // given
        // when
        val lotto = lottoTicketMachine.make()
        val lottoNumbers = lotto.numbers

        // then
        lottoNumbers.map {
            assertThat(it.num)
                .isIn(LOTTO_NUM_RANGE.toList())
        }
    }
}
