package domain;

import static domain.MemberName.MAX_NAME_LENGTH;
import static domain.MemberName.MIN_NAME_LENGTH;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MemberNameTest {

    @Test
    @DisplayName("이름 객체 생성 성공")
    void test_ok_constructor() {
        MemberName name = new MemberName("name");
        assertThat(name.getName()).isEqualTo("name");
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa"})
    @DisplayName("이름 객체 생성 실패: 5글자 초과")
    void test_exception_moreThanFiveLetters(String name) {
        assertThatThrownBy(() -> new MemberName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "자의 이름만 허용합니다.");
    }

    @Test
    @DisplayName("이름 객체 생성 실패: null")
    void test_exception_null() {
        assertThatThrownBy(() -> new MemberName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 null을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("이름 객체 생성 실패: empty")
    void test_exception_empty() {
        assertThatThrownBy(() -> new MemberName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "자의 이름만 허용합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "abcd!", "이름"})
    @DisplayName("이름 객체 생성 실패: 알파벳, 숫자 이외 입력")
    void test_exception_containsInvalidLetter(String name) {
        assertThatThrownBy(() -> new MemberName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 알파벳과 숫자만 허용합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "a", "B", "cC123"})
    @DisplayName("이름 객체 생성 성공: 알파벳, 숫자로 구성된 1~5글자의 이름")
    void test_ok_withValidLetterAndLength(String name) {
        MemberName memberName = new MemberName(name);
        assertThat(memberName.getName()).isEqualTo(name);
    }
}
