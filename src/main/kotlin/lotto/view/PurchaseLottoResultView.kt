package lotto.view

import lotto.domain.Lotto

class PurchaseLottoResultView {
    fun showLottos(purchasedLottos: List<Lotto>) {
        println("${purchasedLottos.size}개를 구매했습니다.")
        purchasedLottos.forEach {
            println(it.lottoNums.sorted())
        }
        print("\n")
    }
}
