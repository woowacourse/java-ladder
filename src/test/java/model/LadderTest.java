package model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderHeight() {
        Height height = new Height(5);
        Participants participants = new Participants(List.of("pobi", "left", "right"));
        Ladder ladder = new Ladder(new LadderGenerateStrategy(), height, participants);
        assertThat(ladder.getLadderRows().size()).isEqualTo(height.getValue());
    }


    @DisplayName("사다리를 생성할 수 있다.")
    @Test
    void build() {
        Height height = new Height(3);
        Participants participants = new Participants(List.of("pobi", "left", "right"));
        Ladder ladder = new Ladder((x, y) -> List.of(
                List.of(true, false),
                List.of(true, false),
                List.of(false, true)), height, participants);
        assertAll(
                () -> assertThat(ladder.getRow(0).getSpaces()).isEqualTo(List.of(Space.LINE, Space.EMPTY)),
                () -> assertThat(ladder.getRow(1).getSpaces()).isEqualTo(List.of(Space.LINE, Space.EMPTY)),
                () -> assertThat(ladder.getRow(2).getSpaces()).isEqualTo(List.of(Space.EMPTY, Space.LINE))
        );

    }
}
