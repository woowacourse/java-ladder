package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

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
    void 공백제거시_값을_반환하는지_테스트() {
        assertEquals(stringAddCalculator.add("   1:2    "), 3);
    }

    @Test
    void 문자_하나_입려을_숫자로_반환하는지_테스트() {
        assertEquals(stringAddCalculator.add("3"), 3);
    }

    @Test
    void 컴마_구분자를_포함하여_입력할_경우_두_숫자의_합을_반환하는지_테스트() {
        assertEquals(stringAddCalculator.add("1,2"), 3);
    }

    @Test
    void 컴마및_콜론을_구분자로_하여_입력할_경우_두_숫자의_합을_반환하는지_테스트() {
        assertEquals(stringAddCalculator.add("1:2"), 3);
        assertEquals(stringAddCalculator.add("1,2:3"), 6);
    }

    @Test
    void 슬래쉬_두개와_개행문자_사이에_커스텀_구분자를_지정하여_두숫자의_합을_반환하는_테스트() {
        assertEquals(stringAddCalculator.add("//;\n1;2;3"), 6);
    }

    @Test
    void 음수를_전달할_경우_RuntimeException_이_발생하는지_테스트() {
        assertThrows(RuntimeException.class, () -> {
            stringAddCalculator.add("-1:2:3");
        });
    }

    @Test
    void 구분자를_해석할수_없는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringAddCalculator.add("//;\n//;\n1;2;3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            stringAddCalculator.add("1//2--3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            stringAddCalculator.add("//;;\n1;2;3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            stringAddCalculator.add("//\n1;2;3");
        });
    }

    @Test
    void 구분자가_숫자가_오는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringAddCalculator.add("//2\n123");
        });
    }

    @AfterEach
    void tearDown() {
        stringAddCalculator = null;
    }
}
