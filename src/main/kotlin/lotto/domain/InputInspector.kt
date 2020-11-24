package lotto.domain

import lotto.view.InputView

object InputInspector {
    fun checkAmountInputType(amount: Int?){
        require(amount is Int) {
            "금액은 1원 단위로 입력하십시오. 입력금액: ${InputView.amountOfLotto}"
        }
    }
    fun checkWinningLottoNumber(){
        val countOfWinningNumber = InputView.winningNumberList?.size
        require(countOfWinningNumber == 6) {
            "당첨 번호는 6개 입니다. 현재 입력 갯수: ${countOfWinningNumber}"
        }
    }

    fun checkWinningNumberType() {
        val winningNumberList = InputView.winningNumberList
        winningNumberList?.forEach {
            require(it is Int){
                "당첨번호는 모두 정수여야 합니다. 정수가 아닌 당첨번호: ${it}"
            }
        }
    }
}
