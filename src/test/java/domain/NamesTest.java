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

    @ParameterizedTest
    @ValueSource(strings = {
            "a,b,c,d,e,f,g,h,i,j,k",
            "a"})
    @DisplayName("참여자 이름 개수가 부적절하면 예외가 발생한다.")
    void validateNameCount(String names) {
        Assertions.assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAMES_COUNT.getMessage());
    }
}