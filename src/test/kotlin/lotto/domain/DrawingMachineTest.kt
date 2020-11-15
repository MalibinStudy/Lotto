package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class DrawingMachineTest {
    @Test
    fun `로또의 시작 숫자가 끝보다 클 떄`() {
        val start = 6
        val end = 5

        Assertions.assertThatThrownBy { DrawingMachine(start, end) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또의 시작 범위($start)는 끝($end)보다 커야합니다.")
    }

    @Test
    fun `로또의 시작 숫자와 끝이 같을 때`() {
        val start = 6
        val end = 6

        Assertions.assertThatThrownBy { DrawingMachine(start, end) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또의 시작 범위($start)는 끝($end)보다 커야합니다.")
    }
}
