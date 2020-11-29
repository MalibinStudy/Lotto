package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.LottoNum
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class InputChangerTest {
    @DisplayName("가격 입력시 숫자가 아닌 경우 에러 테스트")
    @Test
    fun toMoneyTest() {
        // given
        val notNumString = "a"
        // then
        Assertions.assertThatThrownBy { InputChanger().toMoney(notNumString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 입력되어야 합니다. 입력값: $notNumString")
    }

    @DisplayName("Lotto 객체 생성 테스트")
    @Test
    fun toLottoTest() {
        // given
        val numString = "1, 2, 3, 4, 5, 6"
        // then
        assertThat(InputChanger().toLotto(numString)).isInstanceOf(Lotto::class.java)
    }

    @DisplayName("Bonus번호를 LottoNum으로 반환 테스트")
    @Test
    fun toBonusLottoNumTest() {
        // given
        val winningLotto = Lotto(setOf(lottoNum(1), lottoNum(2), lottoNum(3), lottoNum(4), lottoNum(5), lottoNum(6)))
        // when
        val bonusNumString = "7"

        // then
        assertThat(InputChanger().toBonusLottoNum(bonusNumString, winningLotto)).isEqualTo(
            LottoNum.valueOf(bonusNumString.toInt())
        )
    }

    private fun lottoNum(num: Int): LottoNum {
        return LottoNum.valueOf(num)
    }
}
