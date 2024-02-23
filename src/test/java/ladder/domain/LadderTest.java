package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리")
public class LadderTest {
    @DisplayName("생성한다.")
    @Test
    void createTest() {
        // given
        List<Line> expected = List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)));

        // when
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false))));

        // then
        assertThat(ladder)
                .extracting("lines")
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
