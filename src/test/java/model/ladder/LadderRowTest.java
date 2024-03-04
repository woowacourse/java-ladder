package model.ladder;

import model.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderRowTest {

    @DisplayName("행 내부의 라인이 겹치지 않도록 생성할 수 있다.")
    @Test
    void create() {
        assertAll(
                () -> assertThat(new LadderRow(new ArrayList<>(List.of(true, true, true, true)))
                        .getSpaces()).isEqualTo(List.of(Space.LINE, Space.EMPTY, Space.LINE, Space.EMPTY)),
                () -> assertThat(new LadderRow(new ArrayList<>(List.of(false, false, false, false)))
                        .getSpaces()).isEqualTo(List.of(Space.EMPTY, Space.EMPTY, Space.EMPTY, Space.EMPTY)),
                () -> assertThat(new LadderRow(new ArrayList<>(List.of(true, false, true, false)))
                        .getSpaces()).isEqualTo(List.of(Space.LINE, Space.EMPTY, Space.LINE, Space.EMPTY)),
                () -> assertThat(new LadderRow(new ArrayList<>(List.of(false, true, true, false)))
                        .getSpaces()).isEqualTo(List.of(Space.EMPTY, Space.LINE, Space.EMPTY, Space.EMPTY))
        );

    }


    @DisplayName("사다리의 행 내에서 라인에 따라 이동할 수 있다.")
    @Test
    void climb() {
        LadderRow ladderRow = new LadderRow(List.of(true, false, true));
        assertAll(
                () -> assertThat(ladderRow.climb(Position.valueOf(0))).isEqualTo(Position.valueOf(1)),
                () -> assertThat(ladderRow.climb(Position.valueOf(1))).isEqualTo(Position.valueOf(0)),
                () -> assertThat(ladderRow.climb(Position.valueOf(2))).isEqualTo(Position.valueOf(3)),
                () -> assertThat(ladderRow.climb(Position.valueOf(3))).isEqualTo(Position.valueOf(2))
        );
    }

}
