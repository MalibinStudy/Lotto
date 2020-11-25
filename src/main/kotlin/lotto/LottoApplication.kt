import lotto.domain.InputChanger
import lotto.domain.LottoMachine
import lotto.domain.LottoNumGenerator
import lotto.domain.ProfitCalculator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val inputChanger = InputChanger()

    val purchaseCostInput = inputView.getPurchaseCost()
    val purchaseCost = inputChanger.toMoney(purchaseCostInput)

    val lottoNumGenerator = LottoNumGenerator()
    val lottoMachine = LottoMachine()
    val purchasedLottos = lottoMachine.generateLottos(purchaseCost, lottoNumGenerator)

    val resultView = ResultView()
    resultView.showLottos(purchasedLottos)

    val winningLottoInput = inputView.requestWinningLotto()
    val winningLotto = inputChanger.toLotto(winningLottoInput)
    val winLottos = purchasedLottos.resultOfWin(winningLotto)

    val profitCalculator = ProfitCalculator()
    val profitRatio = profitCalculator.getProfitRatio(purchaseCost, winLottos)

    resultView.showWinStatistics(winLottos)
    resultView.showProfitRatio(profitRatio)
}
