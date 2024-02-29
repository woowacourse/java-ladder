package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexTest {

    @DisplayName("인덱스 값을 1 증가시킨다.")
    @Test
    void increase() {
        // given
        Index index = new Index(0);

        // when
        Index expected = index.increase();

        // then
        assertThat(expected.getValue()).isEqualTo(1);
    }

    @DisplayName("인덱스 값을 1 감소시킨다.")
    @Test
    void decrease() {
        // given
        Index index = new Index(1);

        // when
        Index expected = index.decrease();

        // then
        assertThat(expected.getValue()).isEqualTo(0);
    }
}
