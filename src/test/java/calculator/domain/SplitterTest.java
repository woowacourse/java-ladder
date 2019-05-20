package calculator.domain;

import calculator.constants.Constants;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SplitterTest {
    @Test
    void 입력이_없을때() {
        assertThat(new Splitter("").getExpression()).isEqualTo(Arrays.asList(0));
    }

    @Test
    void 디폴트_식_추출() {
        assertThat(new Splitter("1,2:3").getExpression()).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 디폴트_식_추출_숫자하나일때() {
        assertThat(new Splitter("1").getExpression()).isEqualTo(Arrays.asList(1));
    }

    @Test
    void 커스텀_식_추출() {
        assertThat(new Splitter("//;\n1;2;3").getExpression()).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 디폴트_구분자_추출() {
        assertThat(new Splitter("1,2:3").getDelimiter()).isEqualTo(Constants.DEFAULT_DELIMITER);
    }

    @Test
    void 커스텀_구분자_추출() {
        assertThat(new Splitter("//;\n1;2;3").getDelimiter()).isEqualTo(";");
    }

    @Test
    void 디폴트_커스텀_둘_다_아닌경우() {
        assertThrows(Exception.class, () -> {
            new Splitter("1.2.3");
        });
    }
}