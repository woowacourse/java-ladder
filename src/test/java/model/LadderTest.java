package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderHeight() {
        Height height = new Height(5);
        Ladder ladder = new Ladder(height, new LadderRowGenerator(() -> true),
                new Participants(List.of("hello", "hi")));
        assertThat(ladder.getHeight()).isEqualTo(height.value());
    }

    @DisplayName("사다리의 열의 크기는 참가자의 수보다 1 작다")
    @Test
    void ladderColumnOneLessThanParticipantSize() {
        Height height = new Height(5);
        Participants participants = new Participants(List.of("hello", "hi"));
        Ladder ladder = new Ladder(height, new LadderRowGenerator(() -> true), participants);
        assertThat(ladder.getLadderRowSize()).isEqualTo(participants.getParticipantsSize() - 1);
    }

    @DisplayName("참가자의 전체 이동 결과를 알려준다.")
    @Test
    void moveAll() {
        Ladder ladder = new Ladder(
                List.of(new LadderRow(List.of(true, false, false, true)),
                        new LadderRow(List.of(true, false, true, false))));

        assertAll(
                () -> Assertions.assertThat(ladder.moveAll(0)).isEqualTo(0),
                () -> Assertions.assertThat(ladder.moveAll(1)).isEqualTo(1),
                () -> Assertions.assertThat(ladder.moveAll(2)).isEqualTo(3),
                () -> Assertions.assertThat(ladder.moveAll(3)).isEqualTo(4),
                () -> Assertions.assertThat(ladder.moveAll(4)).isEqualTo(2)
        );
    }
}
