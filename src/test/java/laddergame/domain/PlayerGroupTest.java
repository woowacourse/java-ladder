package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerGroupTest {
    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = Arrays.asList(new Player(new PlayerName("a")), new Player(new PlayerName("b")), new Player(new PlayerName("c")));
    }

    @Test
    void create() {
        PlayerGroup playerGroup = new PlayerGroup(players);
        assertEquals(new PlayerGroup(players), playerGroup);
    }

    @Test
    void 플레이어수가_정확하게_나오는지_테스트() {
        assertEquals(new PlayerGroup(players).getCountOfPlayers(), 3);
    }

    @Test
    void 클론이_제대로_됐는지_테스트() {
        assertThat((new PlayerGroup(players).clone() == new PlayerGroup(players))
                && (new PlayerGroup(players).equals(new PlayerGroup(players)))).isFalse();
    }
}
