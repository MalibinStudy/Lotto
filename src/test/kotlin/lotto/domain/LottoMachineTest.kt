package lotto.domain

import lotto.domain.data.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoMachineTest {
    @DisplayName("가격 넣으면 로또 그만큼 생성한 리스트 반환하도록")
    @Test
    fun generateLottosTest() {
        // given
        val lottoMachine = LottoMachine()
        val lottoNumGenerator = LottoNumGenerator()
        // when
        val purchaseCost = Money(30000)
        // then
        assertThat(lottoMachine.generateLottos(purchaseCost, lottoNumGenerator).lottos.size).isEqualTo(30)
    }
}
