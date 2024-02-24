package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamesTest {
    @Test
    @DisplayName("사람 이름이 중복되면 예외 발생")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Names("abcde,abcde,abc"))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_DUPLICATE_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {",abc,ab", "abc,ab,", ",abc,ab,"})
    @DisplayName("구분자가 맨 앞이나 맨 뒤에 있으면 예외 발생")
    void validateSeparator(String names) {
        Assertions.assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_NAMES_SEPARATOR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "a,b,c,d,e,f,g,h,i,j,k",
            "a"})
    @DisplayName("참여자 이름 개수가 부적절(2 미만 10 초과)하면 예외 발생")
    void validateNameCount(String names) {
        Assertions.assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_NAMES_RANGE.getMessage());
    }

    @Test
    @DisplayName("참여자 이름 개수가 적절하면 해당 개수만큼 참여자 이름 생성")
    void testGetNames() {
        String givenNames = "a,b,c,d,e";
        Names names = new Names(givenNames);

        int actual = names.getNames().size();
        int expected = 5;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("참여자 이름 개수가 적절하면 해당 사람 개수를 반환할 수 있음")
    void testGetNameCount() {
        String givenNames = "a,b,c,d,e";
        Names names = new Names(givenNames);

        int actual = names.getNameCount();
        int expected = 5;

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}