package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineTest {

    private Line line;

    @BeforeEach
    void setLine() {
        line = new Line(5);
    }

    @Test
    void 가능한_모든_경우에_사다리가_이어집니다() {
        MockGenerator mockGenerator = new MockGenerator(true);
        line.generateRandom(mockGenerator);
        assertThat(line.toDto()).containsExactly(true, false, true, false);
    }

    @Test
    void 모두_빈_사다리가_만들어집니다() {
        MockGenerator mockGenerator = new MockGenerator(false);
        line.generateRandom(mockGenerator);
        assertThat(line.toDto()).containsExactly(false, false, false, false);
    }
}
