package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryCountTest {

    @DisplayName("RetryCount가 0이면 isLimit은 true를 반환한다.")
    @Test
    void isLimit_return_true_if_count_zero () {
        // given
        RetryCount retryCount = new RetryCount(0);
        // when
        boolean result = retryCount.isLimit();
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("RetryCount가 0이 아니면 isLimit은 false를 반환한다.")
    @Test
    void isLimit_return_false_if_count_not_zero () {
        // given
        RetryCount retryCount = new RetryCount(1);
        // when
        boolean result = retryCount.isLimit();
        // then
        assertThat(result).isFalse();
    }
}
