package lotto

import lotto.domain.Lotto
import lotto.domain.LottoCashier
import lotto.domain.LottoScoringMachine
import lotto.view.InputView.receiveMoney
import lotto.view.InputView.receiveWinLottoNumbers
import lotto.view.OutputView.printLottoCount
import lotto.view.OutputView.printLottoScore
import lotto.view.OutputView.printLottos
import lotto.view.OutputView.printProfitRate

fun main() {
    val money = receiveMoney()
    val lottoCount = LottoCashier.calculateLottoCount(money)
    val lottos = LottoCashier.getLotto(lottoCount)
    printLottoCount(lottoCount)
    printLottos(lottos)

    val winLotto = Lotto(receiveWinLottoNumbers())
    val lottoScore = LottoScoringMachine.scoreLottos(winLotto, lottos)
    printLottoScore(lottoScore)

    val profitRate = lottoScore.getProfitRate(money)
    printProfitRate(profitRate)
}
