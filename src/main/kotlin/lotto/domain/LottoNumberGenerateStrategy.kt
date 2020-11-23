package lotto.domain

fun interface LottoNumberGenerateStrategy {
    fun createLottoTicket(): LottoTicket
}
