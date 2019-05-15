package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderCrossbarTest {
    @Test
    void crossbar가_제대로_만들어지는지_테스트() {
        assertTrue(new LadderCrossbar(true).exist());
    }
}
