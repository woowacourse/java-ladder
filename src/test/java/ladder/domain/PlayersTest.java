package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("참여자들을 생성한다.")
    void generateTest() {
        Player player1 = new Player(new Name("a"), new StartIndex(0));
        Player player2 = new Player(new Name("b"), new StartIndex(1));
        Player player3 = new Player(new Name("c"), new StartIndex(2));

        assertDoesNotThrow(() -> new Players(List.of(player1, player2, player3)));
    }

    @Test
    @DisplayName("참여자들을 반환한다.")
    void getterTest() {
        Player player1 = new Player(new Name("a"), new StartIndex(0));
        Player player2 = new Player(new Name("b"), new StartIndex(1));
        Player player3 = new Player(new Name("c"), new StartIndex(2));

        List<Player> generatedPlayers = List.of(player1, player2, player3);
        Players players = new Players(generatedPlayers);
        List<Player> receivedPlayers = players.getPlayers();

        Assertions.assertThat(receivedPlayers.size()).isEqualTo(generatedPlayers.size());
        Assertions.assertThat(receivedPlayers).containsExactly(player1, player2, player3);
    }

}
