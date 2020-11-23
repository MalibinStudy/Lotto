package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.LottoNum
import lotto.domain.data.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoMachineTest {
    @DisplayName("가격 넣으면 로또 그만큼 생성한 리스트 반환하도록")
    @Test
    fun generatedLottosTest() {
        // given
        val lottoMachine = LottoMachine()
        val lottoNumGenerator = LottoNumGenerator()

        // when
        val purchaseCost = Money(30000)

        // then
        assertThat(lottoMachine.generateLottos(purchaseCost, lottoNumGenerator).lottos.size).isEqualTo(30)
    }

    @DisplayName("로또 하나 생성하기 테스트")
    @Test
    fun generateLottoTest() {
        // given
        val lottoNums = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(6))
        // when
        val lottoMachine = LottoMachine()
        // then
        assertThat(lottoMachine.generateLotto(lottoNums)).isInstanceOf(Lotto::class.java)
        assertThat(lottoMachine.generateLotto(lottoNums).lottoNums).isEqualTo(
            setOf(
                LottoNum(1),
                LottoNum(2),
                LottoNum(3),
                LottoNum(4),
                LottoNum(5),
                LottoNum(6)
            )
        )
    }
}
