package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexTest {
    @Test
    @DisplayName("인덱스가 1만큼 증가한다")
    void increase() {
        final Index index = new Index(3);

        Assertions.assertThat(index.increase()).isEqualTo(new Index(4));
    }

    @Test
    @DisplayName("인덱스가 1만큼 감소한다")
    void decrease() {
        final Index index = new Index(3);

        Assertions.assertThat(index.decrease()).isEqualTo(new Index(2));
    }

}
