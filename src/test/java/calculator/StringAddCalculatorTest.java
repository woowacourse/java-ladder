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

    @AfterEach
    void tearDown() {
        stringAddCalculator = null;
    }
}
