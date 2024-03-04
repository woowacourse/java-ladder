package model;

import static model.Line.CONNECTED;
import static model.Line.NOT_CONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderRowTest {

    @DisplayName("참가자들의 인덱스 번호를 주면 한 행에 대해서 이동 결과를 알려준다.")
    @Test
    void moveParticipant() {
        LadderRow ladderRow = new LadderRow(()->true, 4);

        assertAll(() -> assertThat(ladderRow.findLinkedPosition(new Position(0))).isEqualTo(new Position(1)),
                () -> assertThat(ladderRow.findLinkedPosition(new Position(1))).isEqualTo(new Position(0)),
                () -> assertThat(ladderRow.findLinkedPosition(new Position(2))).isEqualTo(new Position(3)),
                () -> assertThat(ladderRow.findLinkedPosition(new Position(3))).isEqualTo(new Position(2)),
                () -> assertThat(ladderRow.findLinkedPosition(new Position(4))).isEqualTo(new Position(4)));
    }

    @DisplayName("연속된 true 값이 나올 수 없다.")
    @Test
    void createNotConsecutiveTrue() {
        LadderRow ladderRow = new LadderRow(() -> true, 5);
        Assertions.assertThat(ladderRow.getIsLines())
                .isEqualTo(List.of(CONNECTED, NOT_CONNECTED, CONNECTED, NOT_CONNECTED, CONNECTED));
    }
}
