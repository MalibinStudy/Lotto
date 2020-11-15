import lotto.domain.LotteryWallet
import lotto.domain.WinningResult
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchasePrice = InputView.getPurchasePrice()
    val myLotteryWallet = LotteryWallet(purchasePrice)
    OutputView.printAllOfMyLotto(myLotteryWallet)

    val winningNumberList = InputView.getWinningNumber()
    OutputView.showMyResult(WinningResult(winningNumberList), myLotteryWallet)
}
