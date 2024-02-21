package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamesTest {
    @Test
    @DisplayName("사람 이름 중복 검사")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Names("abcde,abcde,abc"))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAMES_DUPLICATE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {",abc,ab", "abc,ab,", ",abc,ab,"})
    @DisplayName("구분자가 맨 앞이나 맨 뒤에 있는지 확인")
    void validateSeparator(String names) {
        Assertions.assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAMES_SEPARATOR.getMessage());
    }

    @Test
    @DisplayName("사람이름 개수 검사")
    void validateNameCount() {
        Assertions.assertThatThrownBy(() -> new Names("a,b,c,d,e,f,g,h,i,j,k"))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAMES_COUNT.getMessage());
    }
}