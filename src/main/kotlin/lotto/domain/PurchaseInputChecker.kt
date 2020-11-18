package lotto.domain

class PurchaseInputChecker {
    fun checkPurchasePrice(string: String) {
        val num = string.toIntOrNull() ?: throw IllegalArgumentException("숫자가 입력되어야 합니다. 입력값: $string")
        lottoNumCheck(num)
    }

    private fun lottoNumCheck(num: Int) {
        require(num >= MINIMUM_PURCHASE_PRICE) { throw IllegalArgumentException("로또 하나의 가격은 1000원입니다. 1000원 이상 입력해주세요\n 입력값: $num") }
    }

    companion object {
        const val MINIMUM_PURCHASE_PRICE = 1000
    }
}
