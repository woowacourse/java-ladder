package additioncalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValuesTest {
    InputValues inputValues;

    @BeforeEach
    void setUp() {
        inputValues = new InputValues();
    }

    @Test
    void 피연산자가_숫자인지_검증() {
        assertThat(inputValues.validateInput("a:1:b")).isFalse();
    }

    @Test
    void 입력값_검증_테스트_될때() {
        assertThat(inputValues.validateInput("//a\n1:2:3")).isTrue();
        assertThat(inputValues.validateInput("//a\n1a2a3")).isTrue();
    }

    @Test
    void 입력값의_맨끝에_구분자가_들어갈때_테스트() {
        assertThat(inputValues.validateInput("//!\n1!2!3!")).isTrue();
    }

    @Test
    void 커스텀_구분자_정규식생성_테스트() {
        assertThat(inputValues.makeRegex("//a\n//b\n1:2a3b6")).isEqualTo("[,]|[:]|(a)|(b)");
    }

}
