package ladder.domain;

import ladder.util.MockedPointGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {

    @Test
    void 라인의_넓이가_1_미만이면_예외() {
        int width = -1;
        List<Boolean> dummy = List.of(true, false, true, false, true);

        assertThatThrownBy(() -> {
            new Line(new MockedPointGenerator(dummy), width);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라인의 넓이는 1이상이어야 합니다.");
    }

    @Test
    void 라인은_연속된_True를_가지지_않는다() {
        List<Boolean> dummy = List.of(true, true, false, true, true);
        List<Boolean> expected = List.of(true, false, false, true, false);
        Line line = new Line(new MockedPointGenerator(dummy), dummy.size());

        assertThat(line.toUnmodifiableLine().stream()
                .map(Point::isAvailable)
                .collect(Collectors.toList()))
                .isEqualTo(expected);
    }

    @ParameterizedTest(name = "라인은 주어진 위치에 대해 방향을 반환한다")
    @CsvSource(value = {"0:RIGHT", "1:LEFT", "2:RIGHT", "4:STRAIGHT"}, delimiter = ':')
    void 라인은_주어진_위치에_대해_방향을_반환한다(int position, Direction expect) {
        List<Boolean> dummy = List.of(true, false, true, false, false);
        Line line = new Line(new MockedPointGenerator(dummy), dummy.size());

        Direction direction = line.decideDirection(position);

        assertThat(direction).isEqualTo(expect);
    }
}
