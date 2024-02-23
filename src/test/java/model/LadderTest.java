package model;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리 높이가 사다리 객체의 크기가 된다.")
    void createLadderWithHeight() {
        // given
        Height height = new Height(5);
        int personCount = 7;

        // when
        Ladder ladder = Ladder.of(height, personCount);

        // when
        Assertions.assertThat(ladder.size()).isEqualTo(height.getValue());
    }

    @Test
    @DisplayName("사다리 모양의 객체를 반환한다.")
    void createFormattedLadder() {
        //given
        int personCount = 5;
        var height = new Height(4);
        var buildStrategy = new NothingBuildStrategy();

        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(personCount, buildStrategy));
        }

        List<String> expected = List.of("|     |     |     |     |",
                "|     |     |     |     |",
                "|     |     |     |     |",
                "|     |     |     |     |");

        //when
        var ladder = new Ladder(lines);

        //then
        Assertions.assertThat(ladder.getFormattedLines()).isEqualTo(expected);
    }
}
