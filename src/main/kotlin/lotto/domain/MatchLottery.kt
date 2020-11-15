package lotto.domain

object MatchLottery {
    fun checkLottery(lottoNumber: LottoNumber, winningNumber: List<Int>): Int {
        val lottoNumberList = lottoNumber.getLotto()
        return lottoNumberList.filter { winningNumber.contains(it) }.size
    }
}
