package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.List;
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

    @Test
    @DisplayName("사람 이름 구성 문자 검증")
    void validateBlackList() {
        assertThatThrownBy(() -> NameInputView.getNames(() -> "all,abc"))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAME_BLACK_LIST.getMessage());
    }

    @Test
    @DisplayName("결과를 확인하고 싶은 이름이 입력되지 않은 이름인 경우 검증")
    void validateNameNotFound() {
        assertThatThrownBy(() -> NameInputView.getNameThatNeedToShowResult(() -> "abc", List.of("abcd,ab")))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAME_NOT_FOUND.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "all"})
    @DisplayName("결과를 확인하고 싶은 이름이 입력되지 않은 이름인 경우 검증")
    void getNameThatNeedToShowResult(String name) {
        String nameThatNeedToShowResult = NameInputView.getNameThatNeedToShowResult(() -> name, List.of("a", "b", "c"));
        Assertions.assertThat(nameThatNeedToShowResult)
                .isEqualTo(name);
    }
}
