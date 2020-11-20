package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoMachineTest {
    @DisplayName("로또 하나 생성하기 테스트")
    @Test
    fun generateLottoTest() {
        // given
        val lottoNumGenerator = LottoNumGenerator()
        val purchaseCost = Money(1000)

        // when
        val lottoMachine = LottoMachine(lottoNumGenerator)
        // then
        assertThat(lottoMachine.generatedLottos(purchaseCost).getLottos()[0]).isInstanceOf(Lotto::class.java)
    }

    @DisplayName("가격 넣으면 로또 그만큼 생성한 리스트 반환하도록")
    @Test
    fun generatedLottosTest() {
        // given
        val lottoNumGenerator = LottoNumGenerator()

        // when
        val lottoMachine = LottoMachine(lottoNumGenerator)
        val purchaseCost = Money(30000)

        // then
        assertThat(lottoMachine.generatedLottos(purchaseCost).getLottos().size).isEqualTo(30)
    }
}
