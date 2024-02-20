package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa"})
    @DisplayName("이름 입력 실패: 5글자 초과")
    void name_exception_moreThanFiveLetters(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자의 이름만 허용합니다.");
    }

    @Test
    @DisplayName("이름 입력 실패: null")
    void name_exception_null() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름에 null을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("이름 입력 실패: empty")
    void name_exception_empty() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자의 이름만 허용합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "abcd!", "이름"})
    @DisplayName("이름 입력 실패: 알파벳, 숫자 이외 입력")
    void name_exception_containsInvalidLetter(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 알파벳과 숫자만 허용합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "a", "B", "cC123"})
    @DisplayName("이름 입력 성공: 알파벳, 숫자로 구성된 1~5글자의 이름")
    void name_ok_withValidLetterAndLength(String name) {
        assertThatCode(() -> new Name(name))
                .doesNotThrowAnyException();
    }
}
