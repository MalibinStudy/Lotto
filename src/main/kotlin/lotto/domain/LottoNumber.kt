package lotto.domain

data class LottoNumber(
    val lottoNumber: Int
) {
    init {
        require(lottoNumber in LOTTO_MIN_NUM..LOTTO_MAX_NUM) { "입력한 숫자는 로또 번호에 해당하지 않습니다. 입력한 번호: $lottoNumber" }
    }

    override fun toString(): String {
        return lottoNumber.toString()
    }

    companion object {
        const val LOTTO_MIN_NUM = 1
        const val LOTTO_MAX_NUM = 45
    }
}
