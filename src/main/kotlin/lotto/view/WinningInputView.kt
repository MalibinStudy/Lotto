package lotto.view

import java.lang.IllegalArgumentException

class WinningInputView {
    fun requestWinningLottoNum(): List<String> {
        println("지난주 당첨 번호를 입력해 주세요.")
        val numsString = readLine()!!
        val winnerNums = numsString.split(DELIMITER)
        inputInspect(winnerNums)
        return winnerNums
    }

    private fun inputInspect(winnerNums: List<String>) {
        require(winnerNums.size == 6) {
            throw IllegalArgumentException(
                "당첨 번호를 잘못 입력하셨습니다. \n " +
                        "입력값: $winnerNums \n " +
                        "개수와 띄어쓰기에 유의하여 다음과 같이 입력해주세요 : 1, 2, 5, 7, 14, 23"
            )
        }
    }

    companion object {
        const val DELIMITER = ", "
    }
}