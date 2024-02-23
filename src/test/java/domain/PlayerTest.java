package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

    @DisplayName("입력의 길이가 1~5 사이가 아니면 예외를 발생 시킨다")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    public void createByLessThanOneLength(String inputName) {
        assertThatCode(() -> new Player(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("1글자 이상 5글자 이하의 이름만 입력하세요. 입력한 이름: %s", inputName));
    }

    @DisplayName("입력한 이름이 영어가 아니면 에러를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"123", "우테코", "!@#"})
    public void createFailByNonAlphabet(String inputName) {
        assertThatCode(() -> new Player(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("이름은 영어만 가능합니다. 입력한 이름:%s", inputName));
    }

    @DisplayName("정상적인 이름을 입력하면 에러가 발생하지 않는다")
    @Test
    public void createSuccess() {
        assertThatCode(() -> new Player("asd"))
                .doesNotThrowAnyException();
    }
}
