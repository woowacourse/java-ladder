package ladder.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void 이름이_객체에_잘들어가는_경우() {
        assertThat(new Player("pobi").getName()).isEqualTo("pobi");
    }

    @AfterEach
    void tearDown() {

    }
}
