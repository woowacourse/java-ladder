package domain;

import factory.PlayersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersFactoryTest {

    @DisplayName("Players를 생성한다.")
    @Test
    void generatePlayers() {
        // given
        List<String> playerNames = List.of("merry", "milli", "wuga", "bebe", "abel", "dino");

        // when
        Players players = PlayersFactory.of(playerNames);

        // then
        assertThat(players.getPlayerNames())
                .isEqualTo(playerNames);
    }

}
