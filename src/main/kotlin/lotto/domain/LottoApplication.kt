package lotto.domain

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    InputView.inputMoney()
    InputInspector.checkAmountInputType(InputView.amountOfLotto)
    OutputView.printCountOfLotto()

    val autoNumberCreator = AutoNumberCreator()
    val lottoList = autoNumberCreator.createEveryLotto()

    OutputView.printLottoNumberList(lottoList)
    InputView.inputWinningNumber()

    InputInspector.checkWinningLottoNumber()
    InputInspector.checkWinningNumberType()
    OutputView.displayResult(lottoList)
}
