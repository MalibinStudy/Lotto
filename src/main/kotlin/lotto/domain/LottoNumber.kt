package lotto.domain

class LottoNumber(lottoList: List<Int>) {
    private val lottoNumberList = mutableListOf<Int>()

    init {
        lottoNumberList.addAll(lottoList)
    }

    fun getLotto(): List<Int> = lottoNumberList.toList()
}
