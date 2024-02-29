package game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"all", "ALL", "All"})
    @DisplayName("All 명령어 매칭이 정상적으로 동작한다.")
    void checkSameCommandTest(String command) {
        // when
        boolean actual = Command.ALL.isSameCommand(command);
        // then
        assertThat(actual).isTrue();
    }
}
