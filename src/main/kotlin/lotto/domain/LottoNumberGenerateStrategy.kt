package lotto.domain

fun interface LottoNumberGenerateStrategy {
    fun createAutoNumTicket(): LottoTicket
}
