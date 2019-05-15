package ladder.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void 이름이_객체에_잘들어가는_경우() {
        assertThat(new Player("pobi").getName()).isEqualTo("pobi");
    }

    @Test
    void 이름이_5자_초과인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("banana");
        });
    }

    @Test
    void 이름이_없거나_빈칸인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(" ");
        });
    }

    @AfterEach
    void tearDown() {

    }
}
