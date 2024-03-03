package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryHelperTest {

    @Test
    @DisplayName("최대 재시도 횟수까지만 재시도 하는지 검증")
    void retry() {
        int maxRetryCount = 10;
        int retryCount = retrySomeLogic(maxRetryCount);
        Assertions.assertThat(retryCount)
                .isEqualTo(maxRetryCount);
    }

    private static int retrySomeLogic(int maxRetryCount) {
        RetryHelper retryHelper = new RetryHelper(maxRetryCount);
        int[] count = new int[]{-1};
        retryHelper.retry(() -> {
            if (count[0] <= maxRetryCount * 2) {
                count[0]++;
                throw new RuntimeException();
            }
            return 1;
        });
        return count[0];
    }
}
