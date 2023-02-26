package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.info.Rewards;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RewardsTest {
    private static final String SPLIT_DELIMITER = ",";

    @DisplayName("보상의 개수는 2개 이상 100개 이하이다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,b", "a,b,c", "a,b,c,d,e,f"})
    void validRewardsTest(String input) {
        List<String> rewards = Arrays.asList(input.split(SPLIT_DELIMITER));

        assertDoesNotThrow(() -> new Rewards(rewards));
    }

    @DisplayName("보상의 개수가 2개 미만인 경우 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "a"})
    void invalidRewardsTest1(String input) {
        List<String> rewards = Arrays.asList(input.split(SPLIT_DELIMITER));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Rewards(rewards))
                .withMessageContaining("[ERROR] 보상의 개수는 2개 이상 100개 이하여야 합니다.");
    }

    @DisplayName("보상의 개수가 100개 초과인 경우 예외 처리한다.")
    @Test
    void invalidRewardsTest2() {
        String input = "a,".repeat(101);
        List<String> rewards = Arrays.asList(input.split(SPLIT_DELIMITER));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Rewards(rewards))
                .withMessageContaining("[ERROR] 보상의 개수는 2개 이상 100개 이하여야 합니다.");
    }
}
