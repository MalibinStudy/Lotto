package lotto.domain.data

class LottoNum private constructor(
    val value: Int,
) {
    override fun toString(): String {
        return "$value"
    }

    private object LottoNumCache {
        val cache: List<LottoNum> = (MINIMUM_LOTTO_NUM..MAXIMUM_LOTTO_NUM).map { LottoNum(it) }
    }

    companion object {
        const val MINIMUM_LOTTO_NUM = 1
        const val MAXIMUM_LOTTO_NUM = 45
        fun valueOf(num: Int): LottoNum {
            return LottoNumCache.cache[num - 1]
        }
    }
}
