package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoNumberRepositoryTest {
    @Test
    fun `로또의 개수가 6개가 나오는지 테스트`() {
        // than
        assertThat(LottoNumberRepository().getRandomLotto().size)
            .isEqualTo(6)
    }
}
