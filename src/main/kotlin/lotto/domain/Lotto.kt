package lotto.domain

data class Lotto(
    val lottoNums: List<Int>
) {
    fun getCorrectCountToOther(otherLotto: Lotto): Int {
        var correctCount = 0
        lottoNums.forEach {
            if (otherLotto.lottoNums.contains(it)) correctCount++
        }
        return correctCount
    }
}
