package lotto.domain

class LottoNumber private constructor(
    val number: Int
) {
    private object LottoNumberCache {
        val cache = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).map { LottoNumber(it) }
        fun valueOf(number: Int): LottoNumber {
            return cache[number - 1]
        }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45

        fun valueOf(number: Int): LottoNumber {
            checkNumber(number)
            return LottoNumberCache.valueOf(number)
        }

        private fun checkNumber(number: Int) {
            val lottoNumberRange = MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER
            require(number in lottoNumberRange) { "로또 번호는 $MIN_LOTTO_NUMBER 에서 $MAX_LOTTO_NUMBER 사이의 값이어야합니다. 입력한 값: $number" }
        }
    }
}
