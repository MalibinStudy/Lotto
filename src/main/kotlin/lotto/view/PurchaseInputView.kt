package lotto.view

import lotto.domain.InputChecker

class PurchaseInputView {
    fun getPurchasePrice(): Int {
        println("구매 금액을 입력해주세요.")
        val purchasePrice = readLine()!!
        InputChecker.checkPurchasePrice(purchasePrice)
        return purchasePrice.toInt()
    }
}
