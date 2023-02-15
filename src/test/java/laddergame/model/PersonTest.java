package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {
    @Test
    @DisplayName("올바른 값이 들어오면 오류가 발생하지 않는다.")
    void Should_Success_When_NameInput() {
        assertDoesNotThrow(() -> new Person("name"));
    }

    @Test
    @DisplayName("한글이 들어가는 경우 예외 발생")
    void Should_ThrowException_When_KoreanInput() {
        assertThatThrownBy(() -> new Person("이름"));
    }

    @Test
    @DisplayName("앞 뒤의 공백이 있는 문자열이 입력되면 공백이 제거된다.")
    void Should_Trim_When_FrontAndBackBlank() {
        assertThat(new Person(" name ").getName()).isEqualTo(" name ".trim());
    }

    @ParameterizedTest(name = "{displayName} {index} ==> name : ''{0}''")
    @ValueSource(strings = {"", "hihihi", "  ", " hihihihi ", "hi  hi"})
    @DisplayName("공백이 제거된 후 문자열의 길이가 1보다 작고 5보다 클 때 예외 발생")
    void Should_ThrowException_When_OutOfRange(String name) {
        assertThatThrownBy(() -> new Person(name));
    }
}
