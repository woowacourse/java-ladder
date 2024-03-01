package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    @DisplayName("참가자 이름 길이 검증")
    void validatePlayerNameLength(String name) {
        Assertions.assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 1글자 이상 5글자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", " ", "가나다", "abc "})
    @DisplayName("참가자 이름 구성 문자 검증")
    void validatePlayerNameCharacter(String name) {
        Assertions.assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 알파벳 대소문자와 숫자만으로 이루어져야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"robin", "12345", "abc12", "12Abc"})
    @DisplayName("참가자 이름 구성 문자 검증")
    void normalName(String name) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Player(name));
    }

}
