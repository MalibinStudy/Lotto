package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoVendingMachineTest {
    @Test
    fun `가격에 맞게 로또가 구입되는지 확인`() {
        // than
        assertThat(LottoVendingMachine().purchaseLotto(14000).size)
            .isEqualTo(14)
    }
}
