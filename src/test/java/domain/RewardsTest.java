package domain;


import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력된 실행 결과의 수는 ")
class RewardsTest {

    private final List<String> results = List.of("꽝", "5000", "3000", "꽝");

    @DisplayName("참여자의 수와 같아야 한다.")
    @Test
    void resultSizeTest_success() {
        Assertions.assertDoesNotThrow(
            () -> Rewards.of(results, results.size()));
    }

    @DisplayName("참여자의 수와 다르면 예외가 발생한다.")
    @Test
    void resultSizeTest_fail() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> Rewards.of(results, results.size() + 1));
    }
}