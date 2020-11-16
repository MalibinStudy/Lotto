package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoShopTest {

    @DisplayName("가격 넣으면 로또 그만큼 생성한 리스트 반환하도록")
    @Test
    fun purchaseLottoTest() {
        // given
        val lottoGenerator = LottoShop()

        // when
        val lottoNum = 30000

        // then
        assertThat(lottoGenerator.purchaseLottos(lottoNum).size).isEqualTo(30)
    }

    @DisplayName("생성된 리스트가 로또번호가 담긴 Lotto들인지 검사")
    @Test
    fun generateLottoTest() {
        // given
        val lottoGenerator = LottoShop()
        val purchasePrice = 3000

        // when
        val lottos = lottoGenerator.purchaseLottos(purchasePrice)

        // then
        repeat(lottos.size) {
            assertThat(lottos[it].lottoNums).isNotEmpty
        }
    }
}
