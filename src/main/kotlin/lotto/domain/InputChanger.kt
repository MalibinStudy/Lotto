package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.LottoNum
import lotto.domain.data.Money

class InputChanger {
    fun toMoney(string: String): Money {
        val cost = string.toIntOrNull() ?: throw IllegalArgumentException("숫자가 입력되어야 합니다. 입력값: $string")
        return Money(cost)
    }

    fun toLotto(numString: String): Lotto {
        val winnerNums = numString.split(DELIMITER)
        checkWinnerNums(winnerNums)
        val winLottoNums = winnerNums.map { LottoNum(it.toInt()) }.toSet()
        return Lotto(winLottoNums)
    }

    private fun checkWinnerNums(winnerNums: List<String>) {
        require(winnerNums.size == NUM_OF_LOTTO_NUMS) {
            throw IllegalArgumentException(
                "당첨 번호를 잘못 입력하셨습니다. \n입력값: $winnerNums \n개수와 띄어쓰기에 유의하여 다음과 같이 입력해주세요 : 1, 2, 5, 7, 14, 23"
            )
        }
    }

    companion object {
        const val NUM_OF_LOTTO_NUMS = 6
        const val DELIMITER = ", "
    }
}
