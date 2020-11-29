package lotto.domain.data

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class LottoTest {
    @DisplayName("로또 번호 6개가 들어왔는지 검사")
    @Test
    fun lottoNumTest() {
        val lottoNums = setOf(lottoNum(1), lottoNum(2), lottoNum(3), lottoNum(4), lottoNum(5), lottoNum(5))
        // then
        Assertions.assertThatThrownBy { Lotto(lottoNums) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호가 잘못 만들어졌어요 $lottoNums")
    }

    @DisplayName("다른 로또와 비교하여 일치하는 Rank 반환 테스트")
    @Test
    fun getWinnerByCompareTest() {
        // given
        val purchasedLottoNum = setOf(lottoNum(1), lottoNum(2), lottoNum(3), lottoNum(4), lottoNum(5), lottoNum(6))
        val otherLottoNum = setOf(lottoNum(1), lottoNum(3), lottoNum(5), lottoNum(7), lottoNum(9), lottoNum(11))
        val bonusNum = lottoNum(2)
        // when
        val purchasedLotto = Lotto(purchasedLottoNum)
        val otherLotto = Lotto(otherLottoNum)
        // then
        assertThat(purchasedLotto.getWinnerByCompare(otherLotto, bonusNum)).isEqualTo(Rank.FIFTH)
    }

    private fun lottoNum(num: Int): LottoNum {
        return LottoNum.valueOf(num)
    }
}
