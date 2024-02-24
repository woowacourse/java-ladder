package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import domain.Line;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("라인 객체를 정상적으로 생성한다.")
    @Test
    void createLine() {
        assertThatCode(() -> new Line())
                .doesNotThrowAnyException();
    }

    @DisplayName("라인은 다리 숫자에 맞게 다리를 생성한다.")
    @Test
    void makeLeg() {
        Line line = new Line();

        line.makeLeg(3);

        assertThat(line.getLegs().size()).isEqualTo(3);
    }

    @DisplayName("라인을 이루는 다리는 겹치지 않는다")
    @Test
    void makeLegWithUnOverlap() {
        Line line = new Line() {
            @Override
            public boolean generateLeg() {
                return true;
            }
        };

        line.makeLeg(3);
        List<Boolean> legs = line.getLegs();

        for (int i = 1; i < legs.size(); i++) {
            assertThat(legs.get(i)).isNotEqualTo(legs.get(i - 1));
        }
    }
}
