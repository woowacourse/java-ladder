package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BarTest {

    @Test
    @DisplayName("Bar.of()에서 false 값을 받으면 FALSE enum을 반환한다.")
    void test_false_bar() {
        // then
        assertThat(Bar.of(false)).isEqualTo(Bar.FALSE);
    }

    @Test
    @DisplayName("Bar.of()에서 true 값을 받으면 TRUE enum을 반환한다.")
    void test_true_bar() {
        // then
        assertThat(Bar.of(true)).isEqualTo(Bar.TRUE);
    }
}
