package lotto.domain

import java.lang.RuntimeException

class LottoTicket(
    val lottoNumbers: Set<LottoNumber>
) {
    init {
        checkLottoNumbersSize(lottoNumbers)
    }

    private fun checkLottoNumbersSize(lottoNumbers: Set<LottoNumber>) {
        if (lottoNumbers.size != 6) {
            throw RuntimeException("로또 번호는 $LOTTO_NUMBER_COUNT 개 이여야합니다. 현재 로또 번호 갯수: $lottoNumbers.size")
        }
    }

    fun getWinningResult(winningNumbers: List<LottoNumber>): WinningResult {
        val equalCount = winningNumbers.count { lottoNumbers.contains(it) }
        return WinningResult.findByEqualCount(equalCount)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
