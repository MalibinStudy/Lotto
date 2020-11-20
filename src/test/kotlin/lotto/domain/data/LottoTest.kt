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
        val lottoNums = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(5))
        // then
        Assertions.assertThatThrownBy { Lotto(lottoNums) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호가 잘못 만들어졌어요 $lottoNums")
    }

    @DisplayName("다른 로또와 비교하여 일치하는 WinLotto 반환 테스트")
    @Test
    fun getCorrectNumCompareToOtherTest() {
        // given
        val purchasedLottoNum = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(6))
        val otherLottoNum = setOf(LottoNum(1), LottoNum(3), LottoNum(5), LottoNum(7), LottoNum(9), LottoNum(11))

        // when
        val purchasedLotto = Lotto(purchasedLottoNum)
        val otherLotto = Lotto(otherLottoNum)

        // then
        assertThat(purchasedLotto.getWinnerByCompare(otherLotto)?.getCorrectNum()).isEqualTo(3)
    }

    @Test
    fun toStringTest() {
        // given
        val lottoNum = setOf(LottoNum(1), LottoNum(2), LottoNum(3), LottoNum(4), LottoNum(5), LottoNum(6))

        // when
        val lotto = Lotto(lottoNum)

        // then
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }
}
