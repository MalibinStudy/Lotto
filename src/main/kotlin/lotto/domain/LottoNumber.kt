package lotto.domain

class LottoNumber private constructor(val number: Int) {
    init {
        require(number in LOTTO_NUM_RANGE) { "로또 숫자는 1에서 45사이의 숫자입니다." }
    }

    companion object {
        val LOTTO_NUM_RANGE = IntRange(1, 45)

        fun create(number: Int): LottoNumber {
            return LottoNumberCache.getLottoNumber(number)
        }
    }

    private object LottoNumberCache {
        private val CACHE: HashMap<Int, LottoNumber> = hashMapOf()

        fun getLottoNumber(lottoNum: Int): LottoNumber {
            return CACHE.getOrPut(lottoNum, { LottoNumber(lottoNum) })
        }
    }
}
