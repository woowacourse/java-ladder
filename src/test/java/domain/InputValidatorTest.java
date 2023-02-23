package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @DisplayName("실행 결과의 글자 수는 1이상 5 이하이다.")
    @Test
    void validateRewardsLengthTest_success() {
        List<String> rewards = List.of("j", "jo", "joy", "yeon", "yeonk");

        assertDoesNotThrow(
                () -> validator.validateRewardsLength(rewards));
    }

    @DisplayName("실행 결과의 글자 수가 1미만이거나 5 초과이면 예외가 발생한다.")
    @Test
    void validateRewardsLengthTest_fail() {
        List<String> rewards = List.of("", "yeonkk");

        assertThrows(IllegalArgumentException.class,
                () -> validator.validateRewardsLength(rewards));
    }

    @DisplayName("사다리의 높이로 숫자를 입력 받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void validateHeightTest_success(String height) {
        assertDoesNotThrow(
                () -> validator.validateHeight(height));

    }

    @DisplayName("사다리의 높이로 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"joy", "height", "", "!"})
    void validateHeightTest_fail(String height) {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateHeight(height));
    }

    @DisplayName("참여자의 이름은 모두 다르다.")
    @Test
    void validateUserNameTest_success() {
        List<String> usernames = List.of("joy", "pobi", "crong");

        assertDoesNotThrow(
                () -> validator.validateUsername(usernames));
    }

    @DisplayName("참여자 중 같은 이름이 있으면 예외가 발생한다.")
    @Test
    void validateUserNameTest_fail() {
        List<String> usernames = List.of("joy", "joy", "crong");

        assertThrows(IllegalArgumentException.class,
                () -> validator.validateUsername(usernames));
    }
}