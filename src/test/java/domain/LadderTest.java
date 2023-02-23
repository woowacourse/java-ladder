package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import helper.AbstractTestFixture;

public class LadderTest extends AbstractTestFixture {

    @ParameterizedTest(name = "사다리의 높이는 양수만 가능하다")
    @ValueSource(ints = {1, 999})
    void test_ladder_height_success(int height) {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(createLines(height)));
    }

    @Test
    @DisplayName("사다리의 높이가 양수가 아니면 IllegalArgumentException를 던진다")
    void test_ladder_height_throws() {
        assertThatThrownBy(() -> new Ladder(createLines(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리의 너비는 일정해야 한다")
    void test_ladder_width_success() {
        List<Line> lines = List.of(
                new Line(convert(true, false)),
                new Line(convert(false, true)),
                new Line(convert(true, false))
        );

        assertThatNoException().isThrownBy(() -> new Ladder(lines));
    }

    @Test
    @DisplayName("사다리의 너비가 동일하지 않으면 IllegalArgumentException를 던진다")
    void test_ladder_width_throws() {
        List<Line> lines = List.of(
                new Line(convert(true, false)),
                new Line(convert(false, true)),
                new Line(convert(true, false, true))
        );

        assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(lines));
    }

    @ParameterizedTest
    @CsvSource({"0,2", "1,3", "2,0", "3,1"})
    void 특정_위치부터_사다리를_탈_수_있다(int start, int destination) {
        Ladder ladder = createLadderWith(
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true))
        );
        Position foundDestination = ladder.findDestinationFrom(new Position(start));

        assertThat(foundDestination).isEqualTo(new Position(destination));
    }
}
