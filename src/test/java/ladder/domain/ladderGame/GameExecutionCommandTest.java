package ladder.domain.ladderGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameExecutionCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"O", "P", "K", "J", "0"})
    @DisplayName("Y 혹은 N을 입력하지 않을 시 에러를 throw")
    void isGameCommandTest(String inputCommand) {
        Assertions.assertThatThrownBy(() -> GameExecutionCommand.isExecuteGameCommand(inputCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExecutionCommand.EXECUTE_GAME.command + " 혹은 " + GameExecutionCommand.STOP_GAME.command
                        + " 중 하나를 입력해야 합니다.");
    }
}
