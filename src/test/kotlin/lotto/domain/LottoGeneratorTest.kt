package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoGeneratorTest {
    @DisplayName("가격 넣으면 개수 반환 테스트")
    @Test
    fun countLottoNumTest() {
        // given
        val lottoGenerator = LottoGenerator()
        // when
        val value = 30000
        // then
        assertThat(lottoGenerator.countLottoNum(value)).isEqualTo(30)
    }

    @DisplayName("개수 넣으면 로또 그만큼 생성한 리스트 반환하도록")
    @Test
    fun generateLottoTest() {
        // given
        val lottoGenerator = LottoGenerator()

        // when
        val lottoNum = 30
        // then
        assertThat(lottoGenerator.generateLotto(lottoNum).size).isEqualTo(30)
    }
}
