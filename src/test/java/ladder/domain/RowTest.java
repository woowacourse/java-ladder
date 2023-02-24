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
        MockStepGenerator mockGenerator = new MockStepGenerator(Step.CONNECTED);
        row.generateStep(mockGenerator);
        assertThat(row.toDto()).containsExactly(Step.CONNECTED, Step.BLANK, Step.CONNECTED, Step.BLANK,
            Step.CONNECTED);
    }

    @Test
    void 모두_빈_사다리가_만들어집니다() {
        MockStepGenerator mockGenerator = new MockStepGenerator(Step.BLANK);
        row.generateStep(mockGenerator);
        assertThat(row.toDto()).containsExactly(Step.BLANK, Step.BLANK, Step.BLANK, Step.BLANK,
            Step.BLANK);
    }
}
