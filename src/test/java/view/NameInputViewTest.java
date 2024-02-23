package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ExceptionType;
import domain.LadderGameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameInputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {",abc,ab", "abc,ab,", ",abc,ab,"})
    @DisplayName("구분자가 맨 앞이나 맨 뒤에 있는지 확인")
    void validateSeparator(String names) {
        Assertions.assertThatThrownBy(() -> NameInputView.getNames(() -> names))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAMES_SEPARATOR.getMessage());
    }

    @Test
    @DisplayName("사람이름 개수 검사")
    void validateNameCount() {
        Assertions.assertThatThrownBy(() -> NameInputView.getNames(() -> "a,b,c,d,e,f,g,h,i,j,k"))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAMES_COUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef,a"})
    @DisplayName("사람 이름 길이 검증")
    void validateNameLength(String name) {
        assertThatThrownBy(() -> NameInputView.getNames(() -> name))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAME_LENGTH_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345,a", "!@#$%,a", "가나다라마,a"})
    @DisplayName("사람 이름 구성 문자 검증")
    void validateNameCharacters(String name) {
        assertThatThrownBy(() -> NameInputView.getNames(() -> name))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAME_CHARACTER.getMessage());
    }
}