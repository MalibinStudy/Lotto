package lotto.view

object InputView {
    private const val DELIMITER = ","
    fun getPurchaseMoney(): Int {
        println("구입금액을 입력해주세요.")
        return readLine()!!.toInt()
    }

    fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해주세요.")
        val winningNumbers = readLine()!!
            .split(DELIMITER)
            .map { it -> it.toInt() }
        return winningNumbers
    }
}
