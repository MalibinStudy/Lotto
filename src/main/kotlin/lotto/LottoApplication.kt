import lotto.domain.InputChanger
import lotto.domain.LottoMachine
import lotto.domain.LottoNumGenerator
import lotto.domain.ProfitCalculator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val inputChanger = InputChanger()

    val purchaseCost = inputChanger.toMoney(inputView.getPurchaseCost())

    val lottoNumGenerator = LottoNumGenerator()
    val lottoMachine = LottoMachine()
    val purchasedLottos = lottoMachine.generateLottos(purchaseCost, lottoNumGenerator)

    val resultView = ResultView()
    resultView.showLottos(purchasedLottos)

    val winningLotto = inputChanger.toLotto(inputView.requestWinningLotto())
    val bonusNum = inputChanger.toBonusLottoNum(inputView.requestBonusNum(), winningLotto)

    val winLottos = purchasedLottos.resultOfWin(winningLotto, bonusNum)

    val profitCalculator = ProfitCalculator()
    val profitRatio = profitCalculator.getProfitRatio(purchaseCost, winLottos)

    resultView.showWinStatistics(winLottos)
    resultView.showProfitRatio(profitRatio)
}
