package ladder.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

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
        List<Boolean> dummy = List.of(true, true, true);
        List<Boolean> expected = List.of(true, false, true);
        Line line = new Line(new MockedPointGenerator(dummy), dummy.size());

        assertThat(line.toUnmodifiableLine().stream()
                .map(Point::isAvailable)
                .collect(Collectors.toList()))
                .isEqualTo(expected);
    }

    private static class MockedPointGenerator implements RandomGenerator<Boolean> {

        private final List<Boolean> dummy;
        private int index = 0;

        private MockedPointGenerator(final List<Boolean> dummy) {
            this.dummy = dummy;
        }

        @Override
        public Boolean generate() {
            return dummy.get(index++);
        }
    }
}
