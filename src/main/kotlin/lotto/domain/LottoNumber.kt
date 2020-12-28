package lotto.domain

class LottoNumber private constructor(
    val lottoNumber: Int
) {

    override fun toString(): String {
        return lottoNumber.toString()
    }

    private object LottoNumberCache {
        val cache = (LOTTO_MIN_NUM..LOTTO_MAX_NUM).map { LottoNumber(it) }
    }

    companion object {
        const val LOTTO_MIN_NUM = 1
        const val LOTTO_MAX_NUM = 45
        fun from(number: Int): LottoNumber {
            require(number in LOTTO_MIN_NUM..LOTTO_MAX_NUM) { "입력한 숫자는 로또 번호에 해당하지 않습니다. 입력한 번호: $number" }
            return LottoNumberCache.cache[number - 1]
        }
    }
}
