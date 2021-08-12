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

    fun getWinningTicket(): LottoTicket {
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber()
        val lottoTicket = mutableListOf<Int>()
        lottoTicket.apply {
            addAll(winningNumbers)
            add(bonusNumber)
        }
        return lottoTicket
            .map { LottoNumber.from(it) }
            .let { LottoTicket(it) }
    }

    private fun getWinningNumbers(): List<Int> {
        print("지난 주 당첨 번호를 입력해 주세요(길이: 6): ")
        val winningNumberInput = readLine()
        require(winningNumberInput != null) { "The input stream is redirected to a file and the end of file has been reached" }
        val splitWinningNumberInput = winningNumberInput.split(Pattern.compile(DELIMITER)).map { it.toInt() }
        require(splitWinningNumberInput.size == 6) { "지난 주 당첨번호의 길이는 6이어야 합니다. 입력 길이 ${splitWinningNumberInput.size}" }
        return splitWinningNumberInput
    }

    private fun getBonusNumber(): Int {
        print("보너스 번호를 입력해 주세요: ")
        return readLine()?.toInt() ?: throw IllegalArgumentException("The input stream is redirected to a file and the end of file has been reached")
    }
}
