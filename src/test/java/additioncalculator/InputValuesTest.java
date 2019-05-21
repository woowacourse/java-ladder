package additioncalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValuesTest {

    @Test
    void 피연산자가_숫자인지_검증() {
        assertThat(InputValues.validateInput("a:1:b")).isFalse();
    }

    @Test
    void 입력값_검증_테스트_될때() {
        assertThat(InputValues.validateInput("//a\n1:2:3")).isTrue();
        assertThat(InputValues.validateInput("//a\n1a2a3")).isTrue();
    }

    @Test
    void 입력값의_맨끝에_구분자가_들어갈때_테스트() {
        assertThat(InputValues.validateInput("//!\n1!2!3!")).isTrue();
    }

    @Test
    void 커스텀_구분자_정규식생성_테스트() {
        assertThat(InputValues.makeRegex("//a\n//b\n1:2a3b6")).isEqualTo("[,]|[:]|(a)|(b)");
    }

    @Test
    void 숫자_뽑아내기_테스트() {
        assertThat(InputValues.extractNumbers("1:2:3")).isEqualTo(Arrays.asList(1,2,3));
    }

}
