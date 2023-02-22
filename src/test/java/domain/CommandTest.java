package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CommandTest {

    @DisplayName("1 ~ 5 글자가 아니면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "skdkds"})
    void createCommand(String input) {
        Assertions.assertThatThrownBy(() -> new Command(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("명령은 1 ~ 5 글자여야 합니다.");
    }

}
