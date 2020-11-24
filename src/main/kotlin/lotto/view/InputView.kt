package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.LottoTicketGenerator

class InputView {
    companion object {

        fun getLottoPurchasedCount(): Long {
            return readLine()!!.toLong()
        }

        fun getWinningLottoTicket(): LottoTicket {
            return readLine()!!
                .split(",")
                .let { LottoTicketGenerator().makeLottoTicket(it) }
        }
    }
}
