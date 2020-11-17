package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinLottoTest {
    @Test
    fun `로또 상금을 받을 수 있는 범위를 벗어난 숫자를 이용해 상금을 탈 수 있는 로또를 나타내는 WinLotto를 가져오려고 할 때 오류발생시키는지 테스트`() {
        assertThatThrownBy { WinLotto.findInstance(1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("winNumberCount는 3, 4, 5, 6 중 하나여야 합니다.")
    }
}
