import domain.Leg;
import domain.Line;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.generator.BooleanGenerator;
import util.generator.RandomBooleanGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LineTest {

    private static BooleanGenerator randomBooleanGenerator;

    @BeforeAll
    static void init() {
        randomBooleanGenerator = new RandomBooleanGenerator();
    }

    @DisplayName("라인 객체를 정상적으로 생성한다.")
    @Test
    void createLine() {
        assertThat(Line.of(3, randomBooleanGenerator).getLegs().size()).isEqualTo(3);
    }

    @DisplayName("라인은 다리 숫자에 맞게 다리를 생성한다.")
    @Test
    void makeLeg() {
        Line line = Line.of(3, randomBooleanGenerator);

        assertThat(line.getLegs().size()).isEqualTo(3);
    }

    @DisplayName("연속된 라인이 생성될 경우 연속되지 않게 수정하여 라인을 생성한다.")
    @Test
    void makeLegWithUnOverlapStartByTrue() {
        assertThat(Line.of(3, new TrueGenerator()).getLegs().size()).isEqualTo(3);
    }

    static class TrueGenerator implements BooleanGenerator {
        @Override
        public boolean generate() {
            return true;
        }
    }
}
