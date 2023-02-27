package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.TestGenerator;

public class LadderTest {
    @Nested
    @DisplayName("사다리 생성")
    class CreateLadder {
        @Test
        @DisplayName("하나의 다리에 사용자가 입력한 높이 만큼의 Line 이 생긴다")
        void createLadderWithEmptyLines() {
            //given
            int personCount = 5;
            String ladderHeight = "3";
            Height height = Height.from(ladderHeight);
            Ladder ladder = Ladder.of(height, personCount);

            //when
            //then
            assertThat(ladder.calculateTotalHeight()).isEqualTo(Integer.parseInt(ladderHeight));
        }

        @Test
        @DisplayName("사다리 생성 테스트")
        void generateLadder() {
            //given
            int personCount = 5;
            Height height = Height.from("2");
            Ladder ladder = Ladder.of(height, personCount);

            //when
            ladder.generate(new TestGenerator(
                    List.of(true, false, true, false,
                            true, false, true, false)));

            //then
            assertThat(ladder.getStatus())
                    .containsExactly(List.of(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST, Bridge.EMPTY),
                            List.of(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST, Bridge.EMPTY));
        }
    }

    @Nested
    @DisplayName("사다리 게임")
    class climbLadder {
        @Test
        @DisplayName("사다리를 타고난 후의 위치값을 제대로 반환하는지 테스트")
        void climbTest() {
            //given
            //when
            Line line1 = new Line(List.of(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST, Bridge.EMPTY));
            Line line2 = new Line(List.of(Bridge.EMPTY, Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST));
            Line line3 = new Line(List.of(Bridge.EXIST, Bridge.EMPTY, Bridge.EMPTY, Bridge.EXIST));
            Ladder ladder = new Ladder(List.of(line1, line2, line3));

            //then
            assertThat(ladder.findFinalPosition(0)).isEqualTo(2);
            assertThat(ladder.findFinalPosition(4)).isEqualTo(4);
        }
    }
}
