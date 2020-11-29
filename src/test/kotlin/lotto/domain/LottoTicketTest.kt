package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class LottoTicketTest {
    @Test
    fun `로또에 중복된 수가 있으면 Exception을 터뜨립니다`() {
        Assertions.assertThatThrownBy {
            LottoTicket(
                listOf(
                    LottoNumber.from(1),
                    LottoNumber.from(1),
                    LottoNumber.from(1),
                    LottoNumber.from(1),
                    LottoNumber.from(1),
                    LottoNumber.from(1),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또에 중복된 숫자는 입력하시면 안됩니다")
    }

    @Test
    fun `길이가 Lotto Length(6)와 맞지 않은 로또는 Excpetion을 터뜨립니다`() {
        Assertions.assertThatThrownBy {
            LottoTicket(
                listOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또의 입력 길이는 ${LottoTicket.LOTTO_LENGTH}가 되어야 합니다. 입력 로또 길이 5")
    }
}
