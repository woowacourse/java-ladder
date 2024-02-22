package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderTest {

    @DisplayName("사다리의 행은 최대 사다리의 높이의 개수와 같다.")
    @Test
    void ladderHeight() {
        int maximumHeight = 5;
        Ladder ladder = new Ladder(maximumHeight);
        ladder.build(3);
        assertThat(ladder.height()).isEqualTo(maximumHeight);
    }
//
//    @DisplayName("최대 사다리의 높이는 양수가 되어야 한다.")
//    @Test
//    void ladderHeightIsPositive() {
//        int maximumHeight = -1;
//        assertThatThrownBy(() -> new Ladder(maximumHeight, List.of()))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("최대 사다리의 높이는 양수가 되어야 합니다");
//    }
//
//    @DisplayName("사다리의 행 내부의 라인은 랜덤하게 결정한다.")
//    @RepeatedTest(100)
//    void makeLines() {
//        Ladder ladder = new Ladder(1, List.of());
//        ladder.createRows();
//        assertThat(ladder.getRow(0).currentWidthSize()).isEqualTo(4);
//    }
//
//    @DisplayName("한 행에는 연속된 선이 존재하면 안된다.")
//    @RepeatedTest(100)
//    void makeNoDuplicatedLineRows() {
//        Ladder ladder = new Ladder(1);
//        ladder.create(5);
//            LadderRow row = ladder.getRow(i);
//        List<Boolean> lines = row.getLines();
//        for (int j = 1; j < 5; j++) {
//            Assertions.assertThat(lines.get(j) && lines.get(j - 1)).isFalse();
//        }
//    }
//
//
//
//    @DisplayName("사다리 행 내부의 라인은 1개 이상이다.")
//    @Test
//    void makeMoreThanOneLine() {
//        LadderRow ladderRow = new LadderRow(4);
//        ladderRow.cross(0, false);
//        ladderRow.cross(0, false);
//        ladderRow.cross(0, false);
//        Ladder ladder = new Ladder(1, List.of(ladderRow));
//        ladder.createRows();
//        assertThat(ladder.getRow(0).getLines().contains(true)).isTrue();
//    }
//
//}
}