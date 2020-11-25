package lotto.domain

class LottoNumber private constructor(
    val number: Int
) {

    override fun toString(): String {
        return "$number"
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45

        fun valueOf(number: Int): LottoNumber {
            validateLottoRange(number)
            return LottoNumberCache.cache[number - 1]
        }

        private fun validateLottoRange(number: Int) {
            require(number in LOTTO_START_NUMBER..LOTTO_END_NUMBER) {
                "로또 번호는 $LOTTO_START_NUMBER ~ $LOTTO_END_NUMBER 사이 값이여야합니다, 입력받은 값: $number"
            }
        }

        private class LottoNumberCache {
            companion object {
                val cache: List<LottoNumber> = (LOTTO_START_NUMBER..LOTTO_END_NUMBER).map { LottoNumber(it) }
            }
        }
    }
}
