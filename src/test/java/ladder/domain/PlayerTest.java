package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    Player player;
    PlayerName name;
    Step stepExist;
    Step stepNotExist;

    @BeforeEach
    void setUp() {
        name = new PlayerName("pobi");
        stepExist = new Step(true);
        stepNotExist = new Step(false);
    }

    @Test
    void 플레이어의_position이_0인_경우_오른쪽에_다리가_있는_경우_position_증가() {
        player = new Player(name, 0);

        player.tryMove(new Steps(Arrays.asList(stepExist, stepNotExist, stepNotExist)));
        assertThat(player.getPosition()).isEqualTo(1);
    }

    @Test
    void 플레이어의_position이_0인_경우_오른쪽에_다리가_없는_경우_position_일정() {
        player = new Player(name, 0);

        player.tryMove(new Steps(Arrays.asList(stepNotExist, stepExist, stepExist)));
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    void 플레이어의_position이_맨끝인_경우_왼쪽에_다리가_있는_경우_position_감소() {
        player = new Player(name, 3);
        player.tryMove(new Steps(Arrays.asList(stepNotExist, stepNotExist, stepExist)));
        assertThat(player.getPosition()).isEqualTo(2);
    }

    @Test
    void 플레이어의_position이_맨끝인_경우_왼쪽에_다리가_없는_경우_position_일정() {
        player = new Player(name, 3);
        player.tryMove(new Steps(Arrays.asList(stepNotExist, stepNotExist, stepNotExist)));
        assertThat(player.getPosition()).isEqualTo(3);
    }

    @Test
    void 플레이어의_position이_양끝이_아닌_경우_오른쪽에_다리가_있는_경우_position_증가() {
        player = new Player(name, 1);
        player.tryMove(new Steps(Arrays.asList(stepNotExist, stepExist, stepNotExist)));
        assertThat(player.getPosition()).isEqualTo(2);
    }

    @Test
    void 플레이어의_position이_양끝이_아닌_경우_왼쪽에_다리가_있는_경우_position_감소() {
        player = new Player(name, 2);
        player.tryMove(new Steps(Arrays.asList(stepNotExist, stepExist, stepNotExist)));
        assertThat(player.getPosition()).isEqualTo(1);
    }

    @Test
    void 플레이어의_position이_양끝이_아닌_경우_양쪽에_다리가_없는_경우_position_일정() {
        player = new Player(name, 1);
        player.tryMove(new Steps(Arrays.asList(stepNotExist, stepNotExist, stepExist)));
        assertThat(player.getPosition()).isEqualTo(1);
    }
}
