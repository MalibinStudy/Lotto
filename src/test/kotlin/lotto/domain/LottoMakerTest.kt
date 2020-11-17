package lotto.domain

import lotto.domain.LottoMaker.LOTTO_LENGTH
import lotto.domain.LottoMaker.LOTTO_NUMBER_RANGE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMakerTest {
    @Test
    fun `로또 번호를 만드는 make()함수가 0에서 45이하의 숫자를 반환하는지 테스트`() {
        // given
        // when
        val lotto = LottoMaker.make()
        val lottoNumbers = lotto.numbers

        // then
        lottoNumbers.map {
            assertThat(it)
                .isIn(LOTTO_NUMBER_RANGE.toList())
        }
    }

    @Test
    fun `로또 번호를 만드는 make()함수가 로또번호 6개를 반환하는지 테스트`() {
        // when
        val lotto = LottoMaker.make()
        val lottoLength = lotto.numbers.size

        // then
        assertThat(lottoLength).isEqualTo(LOTTO_LENGTH)
    }
}
