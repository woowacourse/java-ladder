package ladder.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderPlayerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void 이름이_객체에_잘들어가는_경우() {
        assertThat(new LadderPlayer("pobi").getPlayerName()).isEqualTo("pobi");
    }

    @Test
    void 이름이_5자_초과인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderPlayer("banana");
        });
    }

    @Test
    void 이름이_없거나_빈칸인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderPlayer("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderPlayer(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderPlayer(" ");
        });
    }

    @AfterEach
    void tearDown() {

    }
}
