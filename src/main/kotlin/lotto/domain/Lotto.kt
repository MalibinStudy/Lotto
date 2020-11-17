package lotto.domain

import lotto.domain.LottoMaker.LOTTO_LENGTH

data class Lotto(val numbers: List<Int>) {

    init {
        checkNumberCount()
    }

    private fun checkNumberCount() {
        require(numbers.size > LOTTO_LENGTH) { "로또 숫자는 총 6개입니다." }
    }

    fun checkHas(number: Int): Boolean = numbers.contains(number)
}
