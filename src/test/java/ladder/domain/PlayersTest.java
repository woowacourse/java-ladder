package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    @DisplayName("플레이어 들이 생성된다")
    void setPlayers() {
        List<PlayerName> playerNames = List.of(new PlayerName("hogee"), new PlayerName("jazz"));
        Assertions.assertThatCode(() -> new Players(playerNames))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어 들의 위치를 바꾼다")
    void changePosition() {
        List<PlayerName> playerNames = new ArrayList<>();
        playerNames.add(new PlayerName("hogee"));
        playerNames.add(new PlayerName("jazz"));
        Players players = new Players(playerNames);

        List<PlayerName> copyPlayerNames = new ArrayList<>(playerNames);
        Players copyPlayers = new Players(copyPlayerNames);

        players.changePosition(0, 1);

        PlayerName changePlayerName = players.getPlayers().get(1);
        PlayerName notChangePlayerName = copyPlayers.getPlayers().get(0);

        Assertions.assertThat(changePlayerName.getName())
                .isEqualTo(notChangePlayerName.getName());
    }
}
