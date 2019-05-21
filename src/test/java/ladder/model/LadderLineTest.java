package ladder.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderLineTest {
    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        List<Boolean> crossbars = Arrays.asList(true, false, true);
        ladderLine = new LadderLine(crossbars);
    }

    @Test
    void crossbar가_주어진_column_번호에_존재하는지_확인하는_메소드_테스트() {
        assertTrue(ladderLine.hasCrossbar(0));
        assertFalse(ladderLine.hasCrossbar(1));
        assertTrue(ladderLine.hasCrossbar(0));
    }

    @Test
    void 사다리_Line이_올바르게_만들어지는지_테스트() {
        assertThat(ladderLine.toString()).isEqualTo("|-----|     |-----|");
    }

    @AfterEach
    void tearDown() {
        ladderLine = null;
    }
}
