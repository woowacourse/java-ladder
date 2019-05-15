package ladder.domain;

import org.junit.jupiter.api.BeforeEach;

public class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(4);
    }

    /*
    TODO Random test
    @Test
    void 사용가능한_라인_확인() {
        boolean[] line = {true, false, true, false, false};
        assertThat(line.isValidLine(line)).isTrue();
    }

    @Test
    void 사용가능한_라인_확인() {
        boolean[] line = {true, true, false, false, false};
        assertThat(line.isValidLine(line)).isFalse();
    }*/
}
