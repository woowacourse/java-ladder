package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderPlayerTest {
    @Test
    void 객체에_Player_이름이_잘_입력되었는지_테스트() {
        assertThat(new LadderPlayer("pobi").getPlayerName()).isEqualTo("pobi");
    }

    @Test
    void 이름이_기준치_길이를_초과하는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderPlayer("banana");
        });
    }

    @Test
    void 이름이_없거나_빈칸인_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderPlayer(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderPlayer("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderPlayer(" ");
        });
    }

    @Test
    void 정렬된_이름을_가져오는_메소드_테스트() {
        assertEquals(new LadderPlayer("red").getAlignedPlayerName(), "red   ");
        assertEquals(new LadderPlayer("green").getAlignedPlayerName(), "green ");
    }
}
