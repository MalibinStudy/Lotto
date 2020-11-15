package lotto.domain

import lotto.domain.LotteryWallet.Companion.LOTTO_UNIT_PRICE

object Validation {
    private fun isBiggerThanUnitPrice(price: Int) {
        require(price >= LOTTO_UNIT_PRICE) { "가격은 ${LOTTO_UNIT_PRICE}원보다 커야 합니다." }
    }

    private fun isEndBiggerThanStart(start: Int, end: Int) {
        require(start < end) { "로또의 시작 범위($start)는 끝($end)보다 커야합니다." }
    }

    private fun isSizeFitted(winningNumberList: List<Int>) {
        require(winningNumberList.size == DrawingMachine.LOTTO_LENGTH) {
            "당첨번호의 길이(${winningNumberList.size})가 입력하신 번호는 로또 당첨 번호가 아닙니다: 로또의 길이(${DrawingMachine.LOTTO_LENGTH})와 맞지 않습니다."
        }
    }

    private fun isListSorted(winningNumberList: List<Int>) {
        val sortedWinningNumberList = winningNumberList.sorted()
        require(
            sortedWinningNumberList.filterIndexed
            { index, _ -> sortedWinningNumberList[index] == winningNumberList[index] }.size == sortedWinningNumberList.size
        ) { "입력하신 번호는 로또 당첨 번호가 아닙니다: 정렬이 안되어 있습니다." }
    }

    fun validatePrice(price: Int) {
        isBiggerThanUnitPrice(price)
    }

    fun validateRangeInputs(start: Int, end: Int) {
        isEndBiggerThanStart(start, end)
    }

    fun validateWinningNumbers(winningNumberList: List<Int>) {
        isSizeFitted(winningNumberList)
        isListSorted(winningNumberList)
    }
}
