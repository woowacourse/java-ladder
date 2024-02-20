package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @DisplayName("이름의 길이가 1글자 이상 5글자 이하가 아닌 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void nameLengthTest(String input) {
        Assertions.assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 1글자 이상 5글자 이하여야 합니다.");
    }
}
