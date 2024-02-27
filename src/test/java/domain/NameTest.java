package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("사람 이름 길이가 부적절(1 미만 5 초과)하면 예외 발생")
    void validateNameLength(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_NAME_LENGTH_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "!@#$%", "가나다라마"})
    @DisplayName("사람 이름이 영문 대소문자가 아니면 예외 발생")
    void validateNameCharacters(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_NAME_CHARACTER.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"aaa,aaa,true",
            "aaa,bbb,false"})
    @DisplayName("이름 문자열이 같으면 Name.equals는 true 다르면 false")
    void validateCreateName(String leftName, String rightName, Boolean expected) {
        Name name1 = new Name(leftName);
        Name name2 = new Name(rightName);
        Boolean actual = name1.equals(name2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }


    @Test
    @DisplayName("이름 객체는 이름 문자열을 반환할 수 있음")
    void validateCreateName() {
        String expected = "abcd";
        Name name = new Name(expected);
        String actual = name.getName();
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("프로그램 예약어로 생성하면 예외 발생")
    void validateNameReservedWord() {
        assertThatThrownBy(() -> new Name("all"))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_RESERVED_WORD.getMessage());
    }
}