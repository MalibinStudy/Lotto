package lotto.domain

class LottoTicket(
    val lottoTicket: List<Int>
) {
    fun getMatchCount(winningNumbers: List<Int>): Int {
        return winningNumbers.filter { lottoTicket.contains(it) }.size
    }
}
