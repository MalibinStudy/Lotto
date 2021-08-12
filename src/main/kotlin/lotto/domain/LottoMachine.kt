package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_MAX_NUM
import lotto.domain.LottoNumber.Companion.LOTTO_MIN_NUM
import lotto.domain.LottoTicket.Companion.LOTTO_LENGTH

class LottoMachine : DrawingMethod {
    private val lottoBalls = (LOTTO_MIN_NUM..LOTTO_MAX_NUM).map { LottoNumber.from(it) }

    override fun getLottoTicket(): LottoTicket {
        val shuffledLottoBalls = lottoBalls.shuffled()
        return LottoTicket(
            shuffledLottoBalls
                .take(LOTTO_LENGTH - 1)
                .sortedBy { it.lottoNumber }
                .plus(shuffledLottoBalls[LOTTO_LENGTH])
        )
    }
}
