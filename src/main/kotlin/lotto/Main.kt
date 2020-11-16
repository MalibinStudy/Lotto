import lotto.domain.LottoShop
import lotto.domain.ProfitCalculator
import lotto.domain.WinnerChecker
import lotto.view.PurchaseInputView
import lotto.view.PurchaseLottoResultView
import lotto.view.ResultView
import lotto.view.WinningInputView

fun main() {
    val purchasePrice = PurchaseInputView().getPurchasePrice()

    val lottoShop = LottoShop()
    val purchasedLottos = lottoShop.purchaseLottos(purchasePrice)

    PurchaseLottoResultView().showLottos(purchasedLottos)

    val winningLotto = WinningInputView().requestWinningLotto()

    val winnerChecker = WinnerChecker()
    val winLottos = winnerChecker.getWinLottos(purchasedLottos, winningLotto)

    val profitCalculator = ProfitCalculator()
    val totalProfit = profitCalculator.getTotalProfit(winLottos)
    val profitRatio = profitCalculator.getProfitRatio(purchasePrice, totalProfit)

    ResultView().showWinProfit(winLottos, profitRatio)
}
