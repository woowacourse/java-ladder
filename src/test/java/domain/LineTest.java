package domain;

import ladder.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(5);
    }

    @Test
    void 이전_값이_True이면_False_반환() {
        assertFalse(line.generatePoints(true));
    }

    @Test
    void 이전_값이_False이면_랜덤_반환() {
        List<Boolean> booleans = new ArrayList<>();

        for (int i = 0; i < 100; ++i) {
            booleans.add(line.generatePoints(false));
        }

        assertTrue((booleans.contains(true)) && (booleans.contains(false)));
    }
}
