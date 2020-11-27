package lotto.domain

object LottoNumCache {
    private val cache: HashMap<Int, LottoNum> = hashMapOf()

    fun getLottoNum(lottoNum: Int): LottoNum {
        return cache.getOrPut(lottoNum, { LottoNum(lottoNum) })
    }
}
