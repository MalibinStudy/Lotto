package lotto.view

import lotto.domain.ProfitCalculator

object OutputView {
    private var countOfMatch = 3

    fun printCountOfLotto(countOfLotto: Int?) {
        println("\n${countOfLotto}개를 구매했습니다.")
    }

    fun printLottoNumberList(list: List<List<Int>>) {
        list.forEach {
            println(it)
        }
    }

    fun displayResult(lottoList: List<List<Int>>, amountOfLotto: Int?) {
        val profitCalculator = ProfitCalculator(lottoList)
        val profitRate = profitCalculator.calculate(InputView.winningNumberList, amountOfLotto)

        println("\n당첨 통계\n-------")

        profitCalculator.mapOfResult.forEach {
            println("${countOfMatch}개 일치 (${it.key}원) - ${it.value}개")
            countOfMatch++
        }

        println("총 수익률은 ${profitRate}입니다.")
        countOfMatch = 3
    }
}
