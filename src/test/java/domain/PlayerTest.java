package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("참여자 이름으로 게임 참여자 생성")
    @Test
    public void createPlayerSuccess() {
        String playerNameInput = "pobi";
        PlayerName playerName = new PlayerName(playerNameInput);

        Player player = new Player(playerName);

        assertThat(player.getPlayerName()).isEqualTo(playerNameInput);
    }
}
