package lotto

import lotto.domain.LottoCashier
import lotto.domain.LottoNum.Companion.LOTTO_NUM_RANGE
import lotto.domain.LottoScoringMachine
import lotto.domain.LottoTicket
import lotto.view.InputView.receiveMoney
import lotto.view.InputView.receiveWinLottoNumbers
import lotto.view.OutputView.printLottoCount
import lotto.view.OutputView.printLottoScore
import lotto.view.OutputView.printLottos
import lotto.view.OutputView.printProfitRate

fun main() {
    val money = receiveMoney()
    val lottoCashier = LottoCashier { LOTTO_NUM_RANGE.random() }
    val lottoCount = lottoCashier.calculateLottoCount(money)
    printLottoCount(lottoCount)
    val lottoTickets = lottoCashier.getLotto(lottoCount)
    printLottos(lottoTickets)

    val winLotto = LottoTicket(receiveWinLottoNumbers())
    val winLottoStatistics = LottoScoringMachine.scoreLottoTickets(winLotto, lottoTickets)
    printLottoScore(winLottoStatistics)

    val profitRate = winLottoStatistics.getProfitRate(money)
    printProfitRate(profitRate)
}
