package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGamePlayersTest {
    @Test
    void 플레이어의_수가_부족한_경우_테스트() {
        List<LadderPlayer> players = new ArrayList<>();
        players.add(new LadderPlayer("red"));

        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGamePlayers(players);
        });
    }

    @Test
    void 중복된_플레이어가_존재하는_경우_테스트() {
        List<LadderPlayer> players = new ArrayList<>();
        players.add(new LadderPlayer("red"));
        players.add(new LadderPlayer("red"));

        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGamePlayers(players);
        });
    }

    @Test
    void 게임에서_지정된_예약어를_플레이어_이름으로_사용하는_경우_테스트() {
        List<LadderPlayer> players1 = new ArrayList<>();
        players1.add(new LadderPlayer("all"));
        players1.add(new LadderPlayer("red"));

        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGamePlayers(players1);
        });

        List<LadderPlayer> players2 = new ArrayList<>();
        players2.add(new LadderPlayer("exit"));
        players2.add(new LadderPlayer("red"));

        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGamePlayers(players2);
        });
    }

    @Test
    void 모든_플레이어의_이름들을_추출하는_메소드_테스트() {
        List<LadderPlayer> players = new ArrayList<>(Arrays.asList(new LadderPlayer("red")
                , new LadderPlayer("blue"), new LadderPlayer("green")));

        List<String> playerNames = new LadderGamePlayers(players).getAllPlayerNames();

        assertThat(playerNames.get(0)).isEqualTo("red");
        assertThat(playerNames.get(1)).isEqualTo("blue");
        assertThat(playerNames.get(2)).isEqualTo("green");
    }
}
