package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

    @DisplayName("입력의 길이가 1~5 사이가 아니면 예외를 발생 시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    public void createByLessThanOneLength(String inputName) {
        assertThatCode(() ->
                new Player(inputName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 이름을 입력하면 에러가 발생하지 않는다.")
    @Test
    public void createSuccess() {
        assertThatCode(() -> new Player("asd"))
                .doesNotThrowAnyException();
    }
}
