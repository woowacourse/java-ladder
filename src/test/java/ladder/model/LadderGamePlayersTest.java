package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGamePlayersTest {

    @Test
    void 모든_플레이어가_String형으로_잘들어가는지_테스트() {
        List<LadderPlayer> players = new ArrayList<>();
        players.add(new LadderPlayer("red"));
        players.add(new LadderPlayer("blue"));
        players.add(new LadderPlayer("green"));

        assertThat(new LadderGamePlayers(players).getAllPlayerNames().get(0)).isEqualTo("red");
        assertThat(new LadderGamePlayers(players).getAllPlayerNames().get(1)).isEqualTo("blue");
        assertThat(new LadderGamePlayers(players).getAllPlayerNames().get(2)).isEqualTo("green");
    }
}
