import domain.Leg;
import domain.Line;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.generator.BooleanGenerator;
import util.generator.RandomBooleanGenerator;

import java.util.List;

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
        assertThatCode(() -> Line.of(3, randomBooleanGenerator))
                .doesNotThrowAnyException();
    }

    @DisplayName("라인은 다리 숫자에 맞게 다리를 생성한다.")
    @Test
    void makeLeg() {
        Line line = Line.of(3, randomBooleanGenerator);

        assertThat(line.getLegs().size()).isEqualTo(3);
    }

    @DisplayName("라인의 맨 앞에 다리가 존재할 때 라인을 이루는 다리는 겹치지 않는다")
    @Test
    void makeLegWithUnOverlapStartByTrue() {
        Line line = Line.of(3, new TrueGenerator());

        List<Leg> legs = line.getLegs();

        for (int i = 1; i < legs.size(); i++) {
            assertThat(legs.get(i)).isNotEqualTo(legs.get(i - 1));
        }
    }

    @DisplayName("라인의 맨 앞에 다리가 존재하지 않을 때 라인을 이루는 다리는 겹치지 않는다")
    @Test
    void makeLegWithUnOverlapStartByFalse() {
        Line line = Line.of(3, new FalseGenerator());

        List<Leg> legs = line.getLegs();

        for (int i = 1; i < legs.size(); i++) {
            assertThat(legs.get(i)).isNotEqualTo(legs.get(i - 1));
        }
    }

    static class TrueGenerator implements BooleanGenerator {
        @Override
        public boolean generate() {
            return true;
        }
    }

    static class FalseGenerator implements BooleanGenerator {
        @Override
        public boolean generate() {
            return false;
        }
    }
}
