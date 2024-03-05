package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringParserTest {

    @ParameterizedTest
    @ValueSource(strings = {" a  , b , c ", "a,b,c"})
    @DisplayName("문자열 분리 성공: 쉼표로 분리 후 양 옆 공백 제거")
    void test_ok_splitByDelimiter(String before) {
        assertThat(StringParser.splitByDelimiter(before, ","))
                .containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("문자열 분리 성공: 비정상적인 쉼표 입력")
    void test_ok_abnormalDelimiter() {
        assertThat(StringParser.splitByDelimiter(",,,a", ","))
                .containsExactly("", "", "", "a");
        assertThat(StringParser.splitByDelimiter("a,,,", ","))
                .containsExactly("a", "", "", "");
        assertThat(StringParser.splitByDelimiter(",,,", ","))
                .containsExactly("", "", "", "");
        assertThat(StringParser.splitByDelimiter("bb, ,cc", ","))
                .containsExactly("bb", "", "cc");
    }

    @Test
    @DisplayName("문자열 분리 실패: null 값의 경우 에러 반환")
    void test_exception_null() {
        assertThatThrownBy(() -> StringParser.splitByDelimiter(null, ","))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정수 -> 문자열 반환 성공")
    void test_ok_stringToInt() {
        assertThat(StringParser.stringToInt("1"))
                .isEqualTo(1);
        assertThat(StringParser.stringToInt("-1"))
                .isEqualTo(-1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "-", "@"})
    @DisplayName("정수 -> 문자열 반환 실패: 숫자의 형태가 아닌 문자열")
    void test_exception_nonNumeric(String before) {
        assertThatThrownBy(() -> StringParser.stringToInt(before))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
