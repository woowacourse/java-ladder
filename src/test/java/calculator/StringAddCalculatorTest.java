package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    void 빈_문자열_혹은_null이_입력될_경우_0을_반환하는지_테스트() {
        assertEquals(stringAddCalculator.add(null), 0);
        assertEquals(stringAddCalculator.add(""), 0);
    }

    @Test
    void 문자_하나_입려을_숫자로_반환하는지_테스트() {
        assertEquals(stringAddCalculator.add("3"), 3);
    }

    @Test
    void 컴마_구분자를_포함하여_입력할_경우_두_숫자의_합을_반환하는지_테스트() {
        assertEquals(stringAddCalculator.add("1,2"), 3);
    }

    @AfterEach
    void tearDown() {
        stringAddCalculator = null;
    }
}
