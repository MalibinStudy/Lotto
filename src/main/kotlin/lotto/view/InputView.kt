package lotto.view

object InputView {
    var countOfLotto: Int? = -1
    var amountOfLotto: Int? = -1
    var winningNumberList: List<Int>? = listOf()
    private const val DELIMITER = ","
    private const val PRICE_OF_LOTTO = 1_000

    fun inputMoney() {
        println("구입 금액을 입력해주세요")
        amountOfLotto = readLine()?.toInt()
        countOfLotto = amountOfLotto?.div(PRICE_OF_LOTTO)
    }

    fun inputWinningNumber(): List<Int>? {
        println("\n지난주 당첨번호를 입력해주세요")
        winningNumberList = readLine()?.split(DELIMITER)?.map(String::toInt)

        return winningNumberList
    }
}
