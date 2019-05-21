package ladder.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<LadderLine> lines = new ArrayList<>();

        lines.add(new LadderLine(Arrays.asList(true, false, true)));
        lines.add(new LadderLine(Arrays.asList(true, false, false)));
        lines.add(new LadderLine(Arrays.asList(false, false, true)));

        ladder = new Ladder(lines);
    }

    @Test
    void crossbar가_주어진_column_번호에_존재하는지_확인하는_메소드_테스트() {
        assertTrue(ladder.hasCrossbar(0, 0));
        assertFalse(ladder.hasCrossbar(1, 0));
        assertTrue(ladder.hasCrossbar(0, 1));
        assertFalse(ladder.hasCrossbar(1, 1));
        assertTrue(ladder.hasCrossbar(2, 2));
    }

    @Test
    void ladder의_크기를_반환하는_메소드_테스트() {
        assertEquals(ladder.size(), 3);
    }

    @Test
    void 사다리_Line이_올바르게_만들어지는지_테스트() {
        assertEquals(ladder.toString(), "|-----|     |-----|\n|-----|     |     |\n|     |     |-----|");
    }

    @AfterEach
    void tearDown() {
        ladder = null;
    }
}
