package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import java.lang.RuntimeException

internal class LottoTicketTest {
    @Test
    fun getWinningResultTest() {

    }

    @DisplayName("로또 티켓 생성시 로또번호 개수가 6개가 아닐경우 오류를 터트리는지 테스트")
    @Test
    fun checkLottoNumbersSizeTest() {
        val lottoNumbers = setOf<LottoNumber>(
            LottoNumber.valueOf(12),
            LottoNumber.valueOf(13),
            LottoNumber.valueOf(22),
            LottoNumber.valueOf(33),
            LottoNumber.valueOf(44),
        )

        assertThatThrownBy { LottoTicket(lottoNumbers) }
            .isInstanceOf(RuntimeException::class.java)
    }
}
