import lotto.domain.LottoGenerator
import lotto.domain.LottoInspector
import lotto.view.PurchaseInputView
import lotto.view.PurchaseLottoResultView
import lotto.view.WinLottoResultView
import lotto.view.WinningInputView
import lotto.view.BuyLottoResultView

fun main() {
    val purchasePrice = PurchaseInputView().getPurchasePrice()

    val lottoGenerator = LottoGenerator()
    val numOfLottos = lottoGenerator.countLottoNum(purchasePrice)
    val generatedLottos = lottoGenerator.generateLotto(numOfLottos)

    PurchaseLottoResultView().showLottos(numOfLottos, generatedLottos)

    val winningLotto = WinningInputView().requestWinningLottoNum()

    val lottoWinInspector = LottoInspector()
    val inspectResult = lottoWinInspector.inspectAll(generatedLottos, winningLotto)

    WinLottoResultView().showWinner(inspectResult)
    BuyLottoResultView().showProfitRatio(inspectResult, purchasePrice)
}
