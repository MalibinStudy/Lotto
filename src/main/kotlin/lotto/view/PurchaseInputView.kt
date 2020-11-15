package lotto.view

class PurchaseInputView {
    fun getPurchasePrice(): Int {
        println("구매 금액을 입력해주세요.")
        return stringToNum(readLine()!!)
    }

    private fun stringToNum(string: String): Int {
        val num = string.toIntOrNull() ?: throw IllegalArgumentException("숫자가 입력되어야 합니다. 입력값: $string")
        require(num > 999) { throw IllegalArgumentException("로또 하나의 가격은 1000원입니다. 1000원 단위로 입력해주세요\n 입력값: $num") }
        return num
    }
}
