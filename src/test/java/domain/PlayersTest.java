package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @DisplayName("모든 참여자 이름으로 게임 모든 참여자 생성")
    @Test
    void createPlayersSuccess() {
        String playersNameInput = "pobi,crong,royce,wante";
        PlayerNames playerNames = PlayerNames.of(playersNameInput, ",");

        Players players = Players.from(playerNames);

        assertThat(players.getPlayers()).extracting("playerName")
                .containsExactly("pobi", "crong", "royce", "wante");
    }

}
