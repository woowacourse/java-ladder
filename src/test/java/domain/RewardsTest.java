package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RewardsTest {
    @DisplayName("보상의 입력 개수는 사다리 게임 참가자 수와 동일하다.")
    @ParameterizedTest
    @CsvSource(value = {"a,b:2", "a,b,c:3", "a,b,c,d,e:5"}, delimiter = ':')
    void validRewardsTest(String rewards, int personNumber) {
        assertDoesNotThrow(() -> new Rewards(rewards, personNumber));
    }

    @DisplayName("보상의 입력 개수와 사다리 게임 참가자 수가 다르면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"a,b:3", "a,b,c:2", "a,b,c,d,e:4"}, delimiter = ':')
    void invalidRewardsTest(String rewards, int personNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Rewards(rewards, personNumber))
                .withMessageContaining("[ERROR] 보상의 개수는 사용자의 수와 동일해야 합니다.");
    }
}
