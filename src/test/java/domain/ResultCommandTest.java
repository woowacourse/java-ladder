package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultCommandTest {

    private PlayerNames playerNames;

    @BeforeEach
    void beforeEach() {
        playerNames = PlayerNames.from(List.of("pobi", "hell"));
    }

    @DisplayName("all 이나 Player 의 이름이 아니면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobio", "helo", "al"})
    void getCommandResultFail(String input) {
        ResultCommand resultCommand = new ResultCommand(playerNames);
        Command command = new Command(input);

        assertThatThrownBy(() -> resultCommand.getCommandResult(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("all 이나 Player 의 이름만 입력이 가능합니다.");
    }

    @Test
    @DisplayName("all 이 들어오면 전체 Player 를 반환한다.")
    void getAllPlayerSuccess() {
        ResultCommand resultCommand = new ResultCommand(playerNames);
        Command command = new Command("all");

        List<PlayerName> resultPlayerNames = resultCommand.getCommandResult(command);

        assertThat(resultPlayerNames).hasSize(2);
        assertThat(resultPlayerNames).map(PlayerName::getPlayerName)
                .containsExactly("pobi", "hell");
    }

    @Test
    @DisplayName("이름이 들어오면 해당 Player 를 반환한다.")
    void getPlayerSuccess() {
        ResultCommand resultCommand = new ResultCommand(playerNames);
        Command command = new Command("pobi");

        List<PlayerName> resultPlayerNames = resultCommand.getCommandResult(command);

        assertThat(resultPlayerNames).hasSize(1);
        assertThat(resultPlayerNames.get(0).getPlayerName())
                .isEqualTo("pobi");
    }

}
