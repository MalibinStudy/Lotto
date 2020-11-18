package lotto.domain

import lotto.view.InputView

class AutoNumberCreator {
    fun createEveryLotto(): List<List<Int>> {
        var everyLottoList = mutableListOf<List<Int>>()
        val countOfLotto = InputView.countOfLotto!!

        repeat(countOfLotto) {
            val lottoNumber = createAutoNumber()
            everyLottoList.add(lottoNumber)
        }
        return everyLottoList
    }

    private fun createAutoNumber(): List<Int> {
        return NUMBER_RANGE.shuffled().take(COUNT_OF_LOTTO_NUMBER).sorted()
    }

    companion object {
        private val NUMBER_RANGE = 1..46
        private const val COUNT_OF_LOTTO_NUMBER = 6
    }
}
