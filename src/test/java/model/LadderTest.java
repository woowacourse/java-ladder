package model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderHeight() {
        Height height = new Height(5);
        Ladder ladder = new Ladder();
        Participants participants = new Participants(List.of("pobi", "left", "right"));
        ladder.build(height, participants);
        assertThat(ladder.getLadderRows().size()).isEqualTo(height.getValue());
    }


    @DisplayName("랜덤한 값으로 구성된 사다리를 생성할 수 있다.")
    @RepeatedTest(100)
    void createOneRow() {
        Height height = new Height(1);
        Ladder ladder = new Ladder();
        Participants participants = new Participants(List.of("pobi", "left", "right"));
        ladder.build(height, participants);
        assertThat(ladder.getRow(0).getSpaces())
                .containsAnyOf(Space.LINE, Space.EMPTY);
    }
}
