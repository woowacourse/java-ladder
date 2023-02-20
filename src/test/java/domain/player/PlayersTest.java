package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    @DisplayName("모든 참여자 이름으로 게임 모든 참여자 생성")
    void createPlayersSuccess() {
        String playersNameInput = "pobi,crong,royce,wante";
        PlayerNames playerNames = PlayerNames.of(playersNameInput, ",");

        Players players = Players.from(playerNames);

        assertThat(players.getPlayers()).extracting("playerName")
                .containsExactly("pobi", "crong", "royce", "wante");
    }

    @Test
    @DisplayName("게임 참여자 이름으로 조회")
    void findByPlayerNameSuccess() {
        String playersNameInput = "pobi,crong,royce,wante";
        PlayerNames playerNames = PlayerNames.of(playersNameInput, ",");
        Players players = Players.from(playerNames);

        Player playerByName = players.findByName("pobi");

        assertThat(playerByName).extracting("playerName")
                .isEqualTo("pobi");
    }

    @Test
    @DisplayName("게임 참여자 이름으로 조회시 존재하지 않으면 예외 발생")
    void findByPlayerNameFail() {
        String playersNameInput = "pobi,crong,royce,wante";
        PlayerNames playerNames = PlayerNames.of(playersNameInput, ",");
        Players players = Players.from(playerNames);

        assertThatThrownBy(() ->
                players.findByName("potu")
        ).isInstanceOf(NoSuchElementException.class);
    }


}
