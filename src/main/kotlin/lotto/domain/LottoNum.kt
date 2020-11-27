package lotto.domain

class LottoNum(val num: Int) {
    init {
        require(num in LOTTO_NUM_RANGE) { "로또 숫자는 1에서 45사이의 숫자입니다." }
    }

    companion object {
        val LOTTO_NUM_RANGE = IntRange(1, 45)
    }
}
