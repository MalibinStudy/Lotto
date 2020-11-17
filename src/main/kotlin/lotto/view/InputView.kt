package lotto.view

object InputView {
    fun receiveMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun receiveWinLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해주세요.")
        return readLine()!!.split(", ")
            .map { it.toInt() }
    }
}
