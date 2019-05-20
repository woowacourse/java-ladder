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
    void 정렬된_이름을_가져오는_메소드_테스트() {
        assertEquals(new LadderPlayer("red").getAlignedPlayerName(), "red   ");
        assertEquals(new LadderPlayer("green").getAlignedPlayerName(), "green ");
    }
}
