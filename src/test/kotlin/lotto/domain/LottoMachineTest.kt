package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoMachineTest {
    @ParameterizedTest
    @CsvSource("20000,20", "3000,3")
    fun getAmountOfLottoTickets(money: Int, ticketCount: Int) {
        assertThat(LottoMachine.getAmountOfLottoTickets(money))
            .isEqualTo(ticketCount)
    }
}
