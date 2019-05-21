package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    Player player;
    PlayerName name;

    @BeforeEach
    void setUp() {
        name = new PlayerName("player");
    }

    @Test
    void 플레이어의_position이_0인_경우_오른쪽에_다리가_있는_경우_position_증가() {
        player = new Player(name, 0);
        player.trymove(Arrays.asList(true, false, true));
        assertThat(player.getPosition()).isEqualTo(1);
    }

    @Test
    void 플레이어의_position이_0인_경우_오른쪽에_다리가_없는_경우_position_일정() {
        player = new Player(name, 0);
        player.trymove(Arrays.asList(false, true, true));
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    void 플레이어의_position이_맨끝인_경우_왼쪽에_다리가_있는_경우_position_감소() {
        player = new Player(name, 3);
        player.trymove(Arrays.asList(false, false, true));
        assertThat(player.getPosition()).isEqualTo(2);
    }

    @Test
    void 플레이어의_position이_맨끝인_경우_왼쪽에_다리가_없는_경우_position_일정() {
        player = new Player(name, 3);
        player.trymove(Arrays.asList(false, true, false));
        assertThat(player.getPosition()).isEqualTo(3);
    }

    @Test
    void 플레이어의_position이_양끝이_아닌_경우_오른쪽에_다리가_있는_경우_position_증가() {
        player = new Player(name, 1);
        player.trymove(Arrays.asList(false, true, false));
        assertThat(player.getPosition()).isEqualTo(2);
    }

    @Test
    void 플레이어의_position이_양끝이_아닌_경우_왼쪽에_다리가_있는_경우_position_감소() {
        player = new Player(name, 2);
        player.trymove(Arrays.asList(false, true, false));
        assertThat(player.getPosition()).isEqualTo(1);
    }

    @Test
    void 플레이어의_position이_양끝이_아닌_경우_양쪽에_다리가_없는_경우_position_일정() {
        player = new Player(name, 1);
        player.trymove(Arrays.asList(false, false, true));
        assertThat(player.getPosition()).isEqualTo(1);
    }
}
