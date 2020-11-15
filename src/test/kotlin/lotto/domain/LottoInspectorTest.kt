package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoInspectorTest {
    @Test
    fun inspectAllTest() {
        // given
        val lottoInspector = LottoInspector()
        val lottoGenerator = LottoGenerator()
        val winningLotto = listOf(1, 3, 5, 7, 9, 11)

        // when
        val generatedLottos = lottoGenerator.generateLotto(10)
        // then
        assertThat(lottoInspector.inspectAll(generatedLottos, winningLotto).size).isEqualTo(10)
    }
}
