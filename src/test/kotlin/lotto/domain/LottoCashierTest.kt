package lotto.domain

import lotto.domain.LottoCashier.getLotto
import lotto.domain.LottoCashier.calculateLottoCount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoCashierTest {
    @ParameterizedTest
    @CsvSource("1000, 1", "10000, 10")
    fun `금액으로부터 사려는 로또의 개수를 올바르게 반환하는지 테스트`(money: Int, expectedLottoCount: Int) {
        // when
        val lottoCount = calculateLottoCount(money)
        assertThat(lottoCount).isEqualTo(expectedLottoCount)
    }

    @ParameterizedTest
    @CsvSource("1", "7")
    fun `로또를 로또머신으로부터 뽑은 것이 알맞은 개수로 출력되었는지 확인하기`(lottoCount: Int) {
        // when
        val lottos = getLotto(lottoCount)

        // then
        assertThat(lottos.size).isEqualTo(lottoCount)
    }
}
