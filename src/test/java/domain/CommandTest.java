package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

    @ParameterizedTest
    @DisplayName("해당 입력이 커맨드에 포함되면 true를 리턴한다.")
    @ValueSource(strings = {"all", "exit"})
    void contain(String command) {
        assertThat(Command.contains(command)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("해당 입력이 커맨드에 포함되지 않으면 false를 리턴한다.")
    @ValueSource(strings = {"not", "command"})
    void notContain(String command) {
        assertThat(Command.contains(command)).isEqualTo(false);
    }

}
