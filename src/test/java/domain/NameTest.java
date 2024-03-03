package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @Test
    @DisplayName("Name 생성 성공: 객체 생성 시 이름을 잘 받아온다.")
    void test_ok_constructor() {
        Name name = Name.from("name");
        assertThat(name.getValue()).isEqualTo("name");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "a", "B", "cC123"})
    @DisplayName("Name 생성 성공: 경계값(1, 5글자)")
    void test_ok_withValidLetterAndLength(String name) {
        assertThatCode(() -> Name.from(name))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Name 생성 실패: all 입력")
    void test_exception_gameCommandAsName() {
        assertThatThrownBy(() -> Name.from("all"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("게임에서 지정한 명령어는 이름으로 지정할 수 없습니다: all");
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa"})
    @DisplayName("Name 생성 실패: 5글자 초과")
    void test_exception_moreThanFiveLetters(String name) {
        assertThatThrownBy(() -> Name.from(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1~5자의 이름만 허용합니다.");
    }

    @Test
    @DisplayName("Name 생성 실패: null")
    void test_exception_null() {
        assertThatThrownBy(() -> Name.from(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름에 null을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("Name 생성 실패: empty")
    void test_exception_empty() {
        assertThatThrownBy(() -> Name.from(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1~5자의 이름만 허용합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "abcd!", "이름"})
    @DisplayName("Name 생성 실패: 알파벳, 숫자 이외 입력")
    void test_exception_containsInvalidLetter(String name) {
        assertThatThrownBy(() -> Name.from(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 알파벳과 숫자만 허용합니다.");
    }
}
