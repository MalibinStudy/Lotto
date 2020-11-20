package lotto.domain.data

data class Lottos(
    private val lottos: List<Lotto>
) {
    fun getLottos(): List<Lotto> {
        return this.lottos.toList()
    }
}
