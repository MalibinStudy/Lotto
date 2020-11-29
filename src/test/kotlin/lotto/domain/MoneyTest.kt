package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class MoneyTest {
    @Test
    fun `돈에 음수를 넣으면 익셉션이 발생해야한다`() {
        // then
        assertThatThrownBy { Money(-1) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("돈은 항상 양수입니다.")
    }

    @Test
    fun `상품값을 입력하면 현재 돈으로 몇개의 상품을 살 수 있는지 계산하는 함수인 getAffordableGoodsCount()가 올바른 값을 반환하는지 테스트`() {
        // given
        val money = Money(14000)

        // when
        val result = money.getAffordableGoodsCount(1000)

        // then
        assertThat(result).isEqualTo(14)
    }
}
