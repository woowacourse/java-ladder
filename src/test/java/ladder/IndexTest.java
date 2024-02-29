package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexTest {

    @Test
    @DisplayName("인덱스가 올바르게 증가한다.")
    void incrementTest() {
        // given
        Index index = Index.of(0);
        // when, then
        assertThat(index.increment()).isEqualTo(Index.of(1));
    }

    @Test
    @DisplayName("인덱스가 올바르게 감소한다.")
    void decrementTest() {
        // given
        Index index = Index.of(1);
        // when, then
        assertThat(index.decrement()).isEqualTo(Index.of(0));
    }

    @Test
    @DisplayName("인덱스 위치를 올바르게 변환한다.")
    void toIntegerTest() {
        // given
        Index index = Index.of(10);
        // when, then
        assertThat(index.toInt()).isEqualTo(10);
    }
}
