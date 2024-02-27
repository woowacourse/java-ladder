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


        //        |-----|     |-----|
//                |     |-----|     |
//                |-----|     |     |

    @DisplayName("사다리의 결과를 알 수 있다.")
    @Test
    void moveAll(){
        Height height = new Height(3);
        Participants participants = new Participants(List.of("pobi", "left", "right", "both"));
        Ladder ladder = new Ladder((x, y) -> List.of(
                List.of(true, false, true),
                List.of(false, true, false),
                List.of(true, false, false)), height, participants);
        assertAll(
                () -> assertThat(ladder.result(0)).isEqualTo(2),
                () -> assertThat(ladder.result(1)).isEqualTo(1),
                () -> assertThat(ladder.result(2)).isEqualTo(3),
                () -> assertThat(ladder.result(3)).isEqualTo(0)
        );


    }

}
