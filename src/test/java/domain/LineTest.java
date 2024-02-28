package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineTest {

    @DisplayName("라인 객체를 정상적으로 생성한다.")
    @Test
    void createLine() {
        assertThatCode(() -> new Line(new RandomLegGenerateStrategy(), 1))
                .doesNotThrowAnyException();
    }

    @DisplayName("라인은 다리 숫자에 맞게 다리를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void makeLeg(int validLegCount) {
        Line line = new Line(new RandomLegGenerateStrategy(), validLegCount);

        int expectedLegCount = line.getLegs().size();

        assertThat(expectedLegCount).isEqualTo(validLegCount);
    }

    @DisplayName("라인을 이루는 다리는 겹치지 않는다")
    @Test
    void makeLegWithUnOverlap() {
        Line line = new Line(new RandomLegGenerateStrategy() {
            @Override
            public boolean generateLeg() {
                return true;
            }
        }, 3);

        List<Leg> legs = line.getLegs();

        for (int i = 1; i < legs.size(); i++) {
            assertThat(legs.get(i).isExistLeg()).isNotEqualTo(legs.get(i - 1).isExistLeg());
        }
    }

    @DisplayName("현재위치(Index)를 받으면 다음 라인의 위치를 반환한다.")
    @Test
    void findNextIndex() {
        Line line = new Line(new RandomLegGenerateStrategy() {
            @Override
            public boolean generateLeg() {
                return true;
            }
        }, 3);
        Assertions.assertAll(
                () -> assertThat(line.moveToNextIndex(0)).isEqualTo(1),
                () -> assertThat(line.moveToNextIndex(3)).isEqualTo(2)
        );

    }
}
