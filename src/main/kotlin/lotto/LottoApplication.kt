package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumber.Companion.LOTTO_NUM_RANGE
import lotto.domain.LottoTicket
import lotto.domain.LottoTicketMachine
import lotto.view.InputView.receiveBonusNumber
import lotto.view.InputView.receiveMoney
import lotto.view.InputView.receiveWinLottoNumbers
import lotto.view.OutputView.printLottoCount
import lotto.view.OutputView.printLottoScore
import lotto.view.OutputView.printLottos
import lotto.view.OutputView.printProfitRate

fun main() {
    val money = receiveMoney()
    val lottoCount = money.getAffordableGoodsCount(LottoTicket.LOTTO_PRICE)
    printLottoCount(lottoCount)
    val lottoTickets = LottoTicketMachine { LOTTO_NUM_RANGE.random() }.make(lottoCount)
    printLottos(lottoTickets)

    val lottoNumbers = receiveWinLottoNumbers().map { LottoNumber.create(it.toInt()) }
    val winLottoTicket = LottoTicket(lottoNumbers)
    val bonusNumber = receiveBonusNumber()
    val winLottoStatistics = lottoTickets.score(winLottoTicket, bonusNumber)
    printLottoScore(winLottoStatistics)

    val profitRate = winLottoStatistics.getProfitRate(money)
    printProfitRate(profitRate)
}
