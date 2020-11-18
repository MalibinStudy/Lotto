package lotto.view

import lotto.domain.PurchaseInputChecker

class PurchaseInputView {
    fun getPurchasePrice(): Int {
        println("구매 금액을 입력해주세요.")
        val purchasePrice = readLine()!!
        PurchaseInputChecker().checkPurchasePrice(purchasePrice)
        return purchasePrice.toInt()
    }
}
