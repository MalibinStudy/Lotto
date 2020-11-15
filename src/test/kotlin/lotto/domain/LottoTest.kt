package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTest {
    @DisplayName("로또 번호 생성하기")
    @Test
    fun createLottoNumsTest() {
        // given
        val lotto = Lotto()
        // when
        lotto.createLottoNums()
        // then
        assertThat(lotto.getLottoNums().size).isEqualTo(6)
    }

    @DisplayName("로또 번호 리스트 가져오기")
    @Test
    fun getLottoNumsTest() {
        // given
        val lotto = Lotto()
        // when

        // then
        assertThat(lotto.getLottoNums()).isNotNull
    }
}
