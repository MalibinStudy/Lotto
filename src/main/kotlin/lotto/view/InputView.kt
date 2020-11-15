package lotto.view

class InputView {
    companion object {
        private const val LOTTO_PRICE = 1000

        fun getLottoPurchasedCount(): Int {
            val purchaseAmount = readLine()!!.toInt()
            require(purchaseAmount >= LOTTO_PRICE) {
                "로또 1장의 가격은 1000원 입니다! 1000원 이상 입력해주세요."
            }
            return purchaseAmount
        }

        fun getLastWeekWinningNumbers(): List<Int> {
            return readLine()!!
                .also { validateLastWeekWinningInput(it) }
                .split(",")
                .map {
                    it.also { validateWinningNumber(it) }.toInt()
                }
        }

        private fun validateLastWeekWinningInput(lastWeekResult: String) {
            require(lastWeekResult.isNotBlank()) { "지난 주 당첨 번호가 비어있습니다." }
        }

        private fun validateWinningNumber(winningNumber: String) {
            require(winningNumber.toIntOrNull() is Int) {
                "당첨 번호가 숫자가 아닙니다!, 숫자가 아닌 입력된 값:$winningNumber"
            }
        }
    }
}
