package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RetryTest {

    @ParameterizedTest(name = "횟수: {0}")
    @ValueSource(ints = {2, 1})
    @DisplayName("남아 있는 횟수가 1회 이상이라면 재시도가 가능하다.")
    void possible_retry_count_more_1(final int value) {
        final Retry retry = new Retry(value);

        assertThatNoException().isThrownBy(() -> retry.decrease());
    }

    @Test
    @DisplayName("재시도 횟수를 감소시킨다.")
    void decrease_retry_count() {
        final Retry retry = new Retry(0);

        assertThatThrownBy(() -> retry.decrease())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("재입력 횟수를 초과하였습니다.");
    }
}
