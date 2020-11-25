package lotto.domain.data

import java.util.EnumMap

data class WinResults(
    val result: EnumMap<LottoResult, Int>
) {
    init {
        require(result.all { it.key.correctNum in MIN_WIN_NUM..MAX_WIN_NUM }) { throw IllegalArgumentException("당첨 개수가 아니에요.\n $result") }
    }

    companion object {
        const val MIN_WIN_NUM = 3
        const val MAX_WIN_NUM = 6
    }
}
