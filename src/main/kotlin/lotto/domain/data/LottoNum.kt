package lotto.domain.data

data class LottoNum(
    val value: Int,
) {
    init {
        require(value in MINIMUM_LOTTO_NUM..MAXIMUM_LOTTO_NUM) { throw IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자만 가능합니다. 현재 값: $value") }
    }

    companion object {
        const val MINIMUM_LOTTO_NUM = 1
        const val MAXIMUM_LOTTO_NUM = 45
        val cache: List<LottoNum> = (MINIMUM_LOTTO_NUM..MAXIMUM_LOTTO_NUM).map { LottoNum(it) }
    }
}
