package lotto.domain

class WinnerChecker {
    fun getWinLottos(purchasedLottos: List<Lotto>, winningLotto: Lotto): List<WinLotto> {
        val eachCorrectNums = purchasedLottos.map { it.getCorrectCountToOther(winningLotto) }
        return filterWinLottos(eachCorrectNums)
    }

    private fun filterWinLottos(eachCorrectNums: List<Int>): List<WinLotto> {
        val winLottos = mutableListOf<WinLotto>()
        for (correctNum in CORRECT_THREE..CORRECT_SIX) {
            val winnerNum = eachCorrectNums.count { it == correctNum }
            val winLotto = WinLotto.findByCorrectNum(correctNum)
            winLotto.setWinnerCount(winnerNum)
            winLottos.add(winLotto)
        }
        return winLottos
    }

    companion object {
        const val CORRECT_THREE = 3
        const val CORRECT_SIX = 6
    }
}
