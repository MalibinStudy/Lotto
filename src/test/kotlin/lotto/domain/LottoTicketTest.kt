package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `입력 Lotto과 몇개의 공통된 숫자를 갖는지 계산하는 함수 테스트 `() {
        // given
        val lottoTicket = LottoTicketMachine { 1 }.make()

        val lottoNumOne = LottoNumCache.getLottoNum(1)
        val lottoNumTwo = LottoNumCache.getLottoNum(2)

        val otherLottoTicket = LottoTicket(
            listOf(
                lottoNumOne,
                lottoNumTwo,
                lottoNumOne,
                lottoNumOne,
                lottoNumTwo,
                lottoNumTwo
            )
        )

        // when
        val result = lottoTicket.countSameNumber(otherLottoTicket)
        lottoTicket.toString()

        // then
        assertThat(result).isEqualTo(3)
    }
}
