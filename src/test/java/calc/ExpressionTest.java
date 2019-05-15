package calc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {
    @Test
    void emptyTest() {
        assertThat(Expression.getTokens("")).isEqualTo(Arrays.asList(0));
    }

    @Test
    void parseSingleNumberTest() {
        assertThat(Expression.getTokens("1")).isEqualTo(Arrays.asList(1));
    }

    @Test
    void parseMultipleNumbersTest() {
        assertThat(Expression.getTokens("1,2:3")).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void parseWithCustomDelimiterTest() {
        assertThat(Expression.getTokens("//!\n1!2,3:4")).isEqualTo(Arrays.asList(1, 2, 3, 4));
    }
}