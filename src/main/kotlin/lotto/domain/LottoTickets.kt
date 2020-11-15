package lotto.domain

import kotlin.math.roundToInt

class LottoTickets(val lottoTickets: List<LottoTicket>) {
    private fun getWinningResult(winningNumbers: List<Int>): List<Int> {
        return lottoTickets.map { it.getMatchCount(winningNumbers) }
    }

    fun getWinningStatics(winningNumbers: List<Int>): WinningStatics {
        val winningResult = getWinningResult(winningNumbers)
        val prizeMoneySum = PrizeCalculator.getPrizeMoneySum(winningResult)
        val purchaseMoney = lottoTickets.size * 1000
        val rateOfProfit = (prizeMoneySum / purchaseMoney.toDouble() * 1000).roundToInt() / 10f
        val isLoss = rateOfProfit < 1.0
        return WinningStatics(winningResult, rateOfProfit, isLoss)
    }

    companion object {
        fun create(ticketCount: Int): LottoTickets {
            val lottoTickets = mutableListOf<LottoTicket>()
            repeat(ticketCount) {
                lottoTickets.add(LottoTicket(LottoNumbersGenerator.generate()))
            }
            return LottoTickets(lottoTickets)
        }
    }
}
