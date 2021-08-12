package lotto

import lotto.domain.AutoNumberCreator
import lotto.domain.InputInspector
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    InputView.inputMoney()
    InputInspector.checkAmountInputType(InputView.amountOfLotto)
    OutputView.printCountOfLotto(InputView.countOfLotto)

    val autoNumberCreator = AutoNumberCreator()
    val lottoList = autoNumberCreator.createEveryLotto(InputView.countOfLotto!!)

    OutputView.printLottoNumberList(lottoList)
    InputView.inputWinningNumber()

    InputInspector.checkWinningLottoNumber()
    InputInspector.checkWinningNumberType()
    OutputView.displayResult(lottoList,InputView.amountOfLotto)
}
