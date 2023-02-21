package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RetryTest {

    @ParameterizedTest(name = "입력: {0}, 출력: {1}")
    @CsvSource(value = {"2:true", "1:true", "0:false"}, delimiter = ':')
    @DisplayName("남아 있는 횟수가 1회 이상이라면 재시도가 가능하다.")
    void checkRetryState(final int value, final boolean result) {
        final Retry retry = new Retry(value);

        assertThat(retry.isPossible()).isEqualTo(result);
    }

    @Test
    @DisplayName("재시도 횟수를 감소시킨다.")
    void decreaseRetryCount() {
        final Retry retry = new Retry(1);

        retry.decrease();

        assertThat(retry.isPossible()).isEqualTo(false);
    }
}
