package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexTest {

    @DisplayName("인덱스 값을 1 증가시킨다.")
    @Test
    void increase() {
        // given
        Index index = new Index(0, "pobi");

        // when
        Index expected = index.increase();

        // then
        assertThat(expected.getValue()).isEqualTo(1);
    }

    @DisplayName("인덱스 값을 1 감소시킨다.")
    @Test
    void decrease() {
        // given
        Index index = new Index(1, "pobi");

        // when
        Index expected = index.decrease();

        // then
        assertThat(expected.getValue()).isEqualTo(0);
    }

    @DisplayName("인덱스 데이터가 1글자 미만이면 예외가 발생한다.")
    @Test
    void createEmptyName() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Index(0, ""));
    }

    @Test
    @DisplayName("인덱스 데이터가 5글자를 초과하면 예외가 발생한다.")
    void createExceedMaxLengthName() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Index(0, "honux1"));
    }
}
