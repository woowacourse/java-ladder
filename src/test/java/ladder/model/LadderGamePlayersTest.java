package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGamePlayersTest {
    @Test
    void 모든_플레이어의_이름들을_추출하는_메소드_테스트() {
        List<LadderPlayer> players = new ArrayList<>();
        players.add(new LadderPlayer("red"));
        players.add(new LadderPlayer("blue"));
        players.add(new LadderPlayer("green"));

        List<String> playerNames = new LadderGamePlayers(players).getAllPlayerNames();

        assertThat(playerNames.get(0)).isEqualTo("red");
        assertThat(playerNames.get(1)).isEqualTo("blue");
        assertThat(playerNames.get(2)).isEqualTo("green");
    }
}
