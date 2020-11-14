package lotto.domain

class LottoGenerator {
    fun countLottoNum(value: Int): Int {
        return value / 1000
    }

    fun generateLotto(numOfLotto: Int): List<Lotto> {
        val generatedLottos = mutableListOf<Lotto>()
        repeat(numOfLotto) {
            val lotto = Lotto()
            lotto.createLottoNums()
            generatedLottos.add(lotto)
        }
        return generatedLottos
    }
}
