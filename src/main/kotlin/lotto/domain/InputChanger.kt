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
        val winLottoNums = winnerNums.map { LottoNum.valueOf(it.toInt()) }.toSet()
        return Lotto(winLottoNums)
    }

    fun toBonusLottoNum(numString: String, winningLotto: Lotto): LottoNum {
        val bonusNum = numString.toInt()
        checkBonusNumDuplicated(bonusNum, winningLotto)
        return LottoNum.valueOf(bonusNum)
    }

    private fun checkBonusNumDuplicated(bonusNum: Int, winningLotto: Lotto) {
        if (winningLotto.lottoNums.contains(LottoNum.valueOf(bonusNum))) {
            println("보너스 번호는 당첨번호와 중복될 수 없습니다. 다시 입력해주세요.")
            val reInputNumString = readLine()!!
            toBonusLottoNum(reInputNumString, winningLotto)
        }
    }

    companion object {
        const val DELIMITER = ", "
    }
}
