package lotto.view

import java.lang.IllegalArgumentException

class WinningInputView {
    fun requestWinningLottoNum(): List<Int> {
        println("지난주 당첨 번호를 입력해 주세요.")
        val numsString = readLine()!!
        val winnerNumsString = numsString.split(DELIMITER)
        inputInspect(winnerNumsString)
        return checkAndChangeToNum(winnerNumsString)
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

    private fun checkAndChangeToNum(winnerNumsString: List<String>): List<Int> {
        val winnerNums = winnerNumsString.map {
            it.toIntOrNull() ?: throw IllegalArgumentException("숫자만 적어주세요 \n 입력값: $it")
        }
        checkLottoNums(winnerNums)
        return winnerNums
    }

    private fun checkLottoNums(winnerNums: List<Int>) {
        winnerNums.forEach {
            require(it in 1..45) { throw IllegalArgumentException("당첨 번호는 1~45 사이의 숫자만 가능합니다 \n 입력값: $it") }
        }
    }

    companion object {
        const val DELIMITER = ", "
    }
}
