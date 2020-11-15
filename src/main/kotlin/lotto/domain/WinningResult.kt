package lotto.domain

class WinningResult(private val winningNumber: List<Int>) {
    fun checkMyLotto(lotteryWallet: LotteryWallet): List<Int> {
        val winningResult = mutableListOf<Int>()
        val myLotto = lotteryWallet.getMyLotto()
        for (lottoNumber in myLotto) {
            winningResult.add(MatchLottery.checkLottery(lottoNumber, winningNumber))
        }
        return winningResult
    }
}