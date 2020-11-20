import lotto.domain.LottoNumGenerator
import lotto.domain.LottoMachine
import lotto.domain.WinnerChecker
import lotto.domain.ProfitCalculator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val purchaseCost = inputView.getPurchasePrice()

    val lottoNumGenerator = LottoNumGenerator()
    val lottoMachine = LottoMachine(lottoNumGenerator)
    val purchasedLottos = lottoMachine.generatedLottos(purchaseCost)

    val resultView = ResultView()
    resultView.showLottos(purchasedLottos)

    val winningLotto = inputView.requestWinningLotto()
    val winnerChecker = WinnerChecker()
    val winLottos = winnerChecker.getWinLottos(purchasedLottos, winningLotto)

    val profitCalculator = ProfitCalculator()
    val profitRatio = profitCalculator.getProfitRatio(purchaseCost, winLottos)

    resultView.showWinStatistics(winLottos)
    resultView.showProfitRatio(profitRatio)
}
