package view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @Test
    @DisplayName("쉼표 기준으로 구분 가능")
    void parseToStringList_normal() {
        List<String> strings = StringParser.parseToStringList("a,b");
        assertThat(strings).containsExactly("a", "b");
    }

    @Test
    @DisplayName("쉼표 좌우 공백 제거 가능")
    void parseToStringList_space() {
        List<String> strings = StringParser.parseToStringList("  a  ,  b  ");
        assertThat(strings).containsExactly("a", "b");
    }

    @Test
    @DisplayName("문자열을 int로 파싱 가능")
    void parseToInt() {
        Assertions.assertAll(
            () -> assertThat(StringParser.parseToInt("-2147483648")).isEqualTo(-2147483648),
            () -> assertThat(StringParser.parseToInt("0")).isEqualTo(0),
            () -> assertThat(StringParser.parseToInt("2147483647")).isEqualTo(2147483647)
        );
    }
}
