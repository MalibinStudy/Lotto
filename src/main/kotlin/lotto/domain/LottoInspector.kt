package lotto.domain

class LottoInspector {
    fun inspectAll(generatedLottos: List<Lotto>, winningLotto: List<Int>): Map<Lotto, Int> {
        val inspectResult = mutableMapOf<Lotto, Int>()
        generatedLottos.forEach { lotto ->
            val correctCount = getCorrectCount(lotto, winningLotto)
            inspectResult[lotto] = correctCount
        }
        return inspectResult
    }

    private fun getCorrectCount(lotto: Lotto, winningLotto: List<Int>): Int {
        var correctCount = 0
        val generatedLotto = lotto.getLottoNums()
        winningLotto.forEach { winNum ->
            if (generatedLotto.contains(winNum)) correctCount++
        }
        return correctCount
    }
}
