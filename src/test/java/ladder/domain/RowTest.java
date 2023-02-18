package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RowTest {

    private Row row;

    @BeforeEach
    void setLine() {
        row = new Row(5);
    }

    @Test
    void 가능한_모든_경우에_사다리가_이어집니다() {
        MockGenerator mockGenerator = new MockGenerator(true);
        row.generateLeg(mockGenerator);
        assertThat(row.toDto()).containsExactly(true, false, true, false, true);
    }

    @Test
    void 모두_빈_사다리가_만들어집니다() {
        MockGenerator mockGenerator = new MockGenerator(false);
        row.generateLeg(mockGenerator);
        assertThat(row.toDto()).containsExactly(false, false, false, false, false);
    }
}
