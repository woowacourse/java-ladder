package ladder.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderControllerTest {
    @Test
    void splitTest() {
        String names = "pobi,denis,whale";
        LadderController ladderController = new LadderController();
        assertThat(ladderController.splitNames(names)).contains("pobi", "denis", "whale");
    }
}
