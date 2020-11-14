package lotto.view

import lotto.domain.Lotto

class PurchaseLottoResultView {
    fun showLottos(numOfLottos: Int, purchasedLottos: List<Lotto>) {
        println("${numOfLottos}개를 구매했습니다.")
        purchasedLottos.forEach {
            println(it.getLottoNums().sorted())
        }
        print("\n")
    }
}
