package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.mock.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("라인 내 발판들을 생성한다.")
    void generateRungs() {
        List<Boolean> rungExist = List.of(true, false, true);
        Line line = new Line(4, new MockBooleanGenerator(rungExist));
        List<Rung> rungs = line.getRungs();
        assertThat(rungs).containsExactly(Rung.EXIST, Rung.EMPTY, Rung.EXIST);
    }

    @Nested
    @DisplayName("라인 내 연속된 발판들은 생성되지 않는다.")
    class NotSuccessiveRungsTest {
        @Test
        @DisplayName("연속되면 발판을 생성하지 않는다. - 1")
        void invalidGenerateRungsV1() {
            List<Boolean> rungExist = List.of(true, true, true);
            Line line = new Line(4, new MockBooleanGenerator(rungExist));
            List<Rung> rungs = line.getRungs();
            assertThat(rungs).containsExactly(Rung.EXIST, Rung.EMPTY, Rung.EXIST);
        }

        @Test
        @DisplayName("연속되면 발판을 생성하지 않는다. - 2")
        void invalidGenerateRungsV2() {
            List<Boolean> rungExist = List.of(true, true, false);
            Line line = new Line(4, new MockBooleanGenerator(rungExist));
            List<Rung> rungs = line.getRungs();
            assertThat(rungs).containsExactly(Rung.EXIST, Rung.EMPTY, Rung.EMPTY);
        }
    }

}
