package domain;

import mock.TrueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    @DisplayName("가로 길이는 사용자 수 -1 이다.")
    void createLineWithPersonCount() {
        int personCount = 4;

        assertThatCode(() -> new Line(personCount, new RandomGenerator())).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("가로 라인은 겹치지 않는다.")
    void createRandomLine() {
        int personCount = 4;
        List<Boolean> expectedPoint = List.of(true, false, true);
        Line line = new Line(personCount, new TrueGenerator());
        List<Boolean> list = line.getPoints().stream()
                .map(Bridge::getBridge)
                .toList();

        assertThat(list).isEqualTo(expectedPoint);
    }
}
