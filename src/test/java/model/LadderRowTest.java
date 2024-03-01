package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderRowTest {

    @DisplayName("연속된 true 값이 존재하면 예외가 발생한다.")
    @Test
    void consecutiveTrueThrowException() {
        assertThatThrownBy(() -> new LadderRow(List.of(true, true, false, false)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("연속된 true 값이 존재하면 안됩니다");
    }

    @DisplayName("참가자들의 인덱스 번호를 주면 한 행에 대해서 이동 결과를 알려준다.")
    @Test
    void moveParticipant() {
        LadderRow ladderRow = new LadderRow(List.of(true, false, false, true));

        assertAll(() -> assertThat(ladderRow.move(new Position(0))).isEqualTo(new Position(1)),
                () -> assertThat(ladderRow.move(new Position(1))).isEqualTo(new Position(0)),
                () -> assertThat(ladderRow.move(new Position(2))).isEqualTo(new Position(2)),
                () -> assertThat(ladderRow.move(new Position(3))).isEqualTo(new Position(4)),
                () -> assertThat(ladderRow.move(new Position(4))).isEqualTo(new Position(3)));
    }
}
