package calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {
    private Expression exp;
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
    }

    @Test
    void emptyTest() {
        exp = new Expression("");
        numbers.add(0);
        assertThat(exp.getNumbers()).isEqualTo(numbers);
    }

    @Test
    void parseSingleNumberTest() {
        exp = new Expression("1");
        numbers.add(1);
        assertThat(exp.getNumbers()).isEqualTo(numbers);
    }

    @Test
    void parseMultipleNumbersTest() {
        exp = new Expression("1,2:3");
        numbers = Arrays.asList(1, 2, 3);
        assertThat(exp.getNumbers()).isEqualTo(numbers);
    }

    @Test
    void parseCustomDelimiterTest() {
        exp = new Expression("//!\n1!2,3:4");
        numbers = Arrays.asList(1, 2, 3, 4);
        assertThat(exp.getNumbers()).isEqualTo(numbers);
    }
}