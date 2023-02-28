package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertThat(row.toDto()).containsExactly(Step.CONNECTED, Step.BLANK, Step.CONNECTED,
            Step.BLANK,
            Step.CONNECTED);
    }

    @Test
    void 모두_빈_사다리가_만들어집니다() {
        MockStepGenerator mockGenerator = new MockStepGenerator(Step.BLANK);
        row.generateStep(mockGenerator);
        assertThat(row.toDto()).containsExactly(Step.BLANK, Step.BLANK, Step.BLANK, Step.BLANK,
            Step.BLANK);
    }

    @ParameterizedTest(name = "{0}와 인접한 좌표는 {1}")
    @CsvSource(value = {"0:0", "1:1", "2:2", "3:3", "4:4"}, delimiter = ':')
    void 빈_사다리에서_인접한_좌표로_이동(Integer input, Integer expected) {
        MockStepGenerator mockGenerator = new MockStepGenerator(Step.BLANK);
        row.generateStep(mockGenerator);
        assertThat(row.findAdjacentIndex(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}와 인접한 좌표는 {1}")
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:5"}, delimiter = ':')
    void 가능한_연결된_사다리에서_인접한_좌표로_이동(Integer input, Integer expected) {
        MockStepGenerator mockGenerator = new MockStepGenerator(Step.CONNECTED);
        row.generateStep(mockGenerator);
        assertThat(row.findAdjacentIndex(input)).isEqualTo(expected);
    }
}
