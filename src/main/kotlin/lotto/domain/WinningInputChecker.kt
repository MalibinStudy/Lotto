package lotto.domain

class WinningInputChecker {
    fun checkWinLottoNum(winnerNumsString: List<String>) {
        inputInspect(winnerNumsString)
        val winnerNums = winnerNumsString.map {
            it.toIntOrNull() ?: throw IllegalArgumentException("숫자만 적어주세요 \n입력값: $winnerNumsString")
        }
        checkLottoNums(winnerNums)
    }

    private fun inputInspect(winnerNums: List<String>) {
        require(winnerNums.size == NUM_OF_LOTTO_NUMS) {
            throw IllegalArgumentException(
                "당첨 번호를 잘못 입력하셨습니다. \n입력값: $winnerNums \n개수와 띄어쓰기에 유의하여 다음과 같이 입력해주세요 : 1, 2, 5, 7, 14, 23"
            )
        }
    }

    private fun checkLottoNums(winnerNums: List<Int>) {
        winnerNums.forEach {
            require(it in MINIMUM_LOTTO_NUM..MAXIMUM_LOTTO_NUM) { throw IllegalArgumentException("당첨 번호는 1~45 사이의 숫자만 가능합니다 \n입력값: $winnerNums") }
        }
    }

    companion object {
        const val NUM_OF_LOTTO_NUMS = 6
        const val MINIMUM_LOTTO_NUM = 1
        const val MAXIMUM_LOTTO_NUM = 45
    }
}
