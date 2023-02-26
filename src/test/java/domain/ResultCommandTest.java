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

    private Players players;

    @BeforeEach
    void beforeEach() {
        players = Players.from(List.of("pobi", "hell"));
    }

    @DisplayName("all 이나 Player 의 이름이 아니면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobio", "helo", "al"})
    void getCommandResultFail(String input) {
        ResultCommand resultCommand = new ResultCommand(players);
        Command command = new Command(input);

        assertThatThrownBy(() -> resultCommand.getCommandResult(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("없는 player 입니다.");
    }

    @Test
    @DisplayName("all 이 들어오면 전체 Player 를 반환한다.")
    void getAllPlayerSuccess() {
        ResultCommand resultCommand = new ResultCommand(players);
        Command command = new Command("all");

        List<Player> resultPlayers = resultCommand.getCommandResult(command);

        assertThat(resultPlayers).hasSize(2);
        assertThat(resultPlayers).map(Player::getName)
                .containsExactly("pobi", "hell");
    }

    @Test
    @DisplayName("이름이 들어오면 해당 Player 를 반환한다.")
    void getPlayerSuccess() {
        ResultCommand resultCommand = new ResultCommand(players);
        Command command = new Command("pobi");

        List<Player> resultPlayers = resultCommand.getCommandResult(command);

        assertThat(resultPlayers).hasSize(1);
        assertThat(resultPlayers.get(0).getName())
                .isEqualTo("pobi");
    }

}
