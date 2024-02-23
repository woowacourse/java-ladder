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
        LadderHeight ladderHeight = LadderHeight.from("4");
        People people = new People(List.of(
                new Person("pobi"),
                new Person("nak"),
                new Person("seya"),
                new Person("neo")));
        List<Line> expected = List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)));

        // when
        Ladder ladder = Ladder.create((width, height) ->
                List.of(
                        new Line(List.of(true, false, true)),
                        new Line(List.of(false, true, false)),
                        new Line(List.of(true, false, false))), people, ladderHeight);

        // then
        assertThat(ladder)
                .extracting("lines")
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
