package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import java.util.regex.Pattern

object InputView {
    private const val DELIMITER = ", "

    fun getPurchasePrice(): Int {
        print("구입 금액을 입력해주세요: ")
        return readLine()!!.toInt()
    }

    fun getWinningNumber(): LottoTicket {
        print("지난 주 당첨 번호를 입력해 주세요: ")
        val winningNumber = readLine()
        require(winningNumber != null) { "The input stream is redirected to a file and the end of file has been reached" }
        return winningNumber
            .split(Pattern.compile(DELIMITER))
            .map { LottoNumber(it.toInt()) }
            .let { LottoTicket(it) }
    }
}
