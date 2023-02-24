package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    private final LineSource I_____I = LineSource.MAKE_LINE;
    private final LineSource IxxxxxI = LineSource.MAKE_BLANK;

    private static List<Line> getFloorLines(int position, Ladder ladder) {
        return ladder.getFloors().get(position).getLines();
    }

    @Test
    @DisplayName("0이하의 값으로 Ladder생성시 예외가 발생한다.")
    void inValidLadderSizeTest() {
        assertThatThrownBy(() -> new Ladder(0, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1이상 입니다.");
    }

    @Test
    @DisplayName("1이상의 값으로 Ladder생성 시 사이즈 테스트")
    void checkValidLadderSizeTest() {
        assertThat(new Ladder(3, 2).getFloors().size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("Ladder 가로 사이즈 테스트")
    void checkLadderWidthTest() {
        Ladder ladder = new Ladder(3, 2);
        List<Floor> floors = ladder.getFloors();

        for (Floor floor : floors) {
            assertThat(floor.getSizeOfLineEdge()).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("Ladder 1층 생성 테스트")
    void makeFirstFloorTest() {
        TestLineSourceGenerator testLineSourceGenerator = new TestLineSourceGenerator(List.of(
                I_____I, IxxxxxI, IxxxxxI
        ));

        Ladder ladder = new Ladder(1, 4);
        ladder.makeFloors(testLineSourceGenerator);

        List<Line> firstFloorLines = getFloorLines(0, ladder);

        assertThat(firstFloorLines.get(0).isExist()).isEqualTo(true);
        assertThat(firstFloorLines.get(1).isExist()).isEqualTo(false);
        assertThat(firstFloorLines.get(2).isExist()).isEqualTo(false);
    }

    @Test
    @DisplayName("Ladder 생성 테스트")
    void makeFloorTest() {
        TestLineSourceGenerator testLineSourceGenerator = new TestLineSourceGenerator(List.of(
                I_____I, IxxxxxI, IxxxxxI,
                I_____I, I_____I, I_____I)
        );

        Ladder ladder = new Ladder(2, 4);
        ladder.makeFloors(testLineSourceGenerator);

        List<Line> firstFloorLines = getFloorLines(0, ladder);
        List<Line> secondFloorLines = getFloorLines(1, ladder);

        assertThat(firstFloorLines.get(0).isExist()).isEqualTo(true);
        assertThat(firstFloorLines.get(1).isExist()).isEqualTo(false);
        assertThat(firstFloorLines.get(2).isExist()).isEqualTo(false);

        assertThat(secondFloorLines.get(0).isExist()).isEqualTo(true);
        assertThat(secondFloorLines.get(1).isExist()).isEqualTo(false);
        assertThat(secondFloorLines.get(2).isExist()).isEqualTo(true);
    }

    @Test
    @DisplayName("아무 연결 없는 일자 사다리일 경우 반환 위치를 제대로 반환하는지 확인")
    void testForStraightBridge() {
        final Users users = new Users(List.of("a", "b", "c", "d"));
        final Ladder ladder = new Ladder(8, 4);
        ladder.makeFloors(new TestLineSourceGenerator(List.of(IxxxxxI)));
        for (int i = 0; i < users.size(); i++) {
            assertThat(ladder.resultPositionOf(i)).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("2줄 짜리 꼬인 사다리 테스트")
    void SecondFloorBridgeTest() {
        final Users users = new Users(List.of("a", "b"));
        final Ladder ladder = new Ladder(2, 2);
        ladder.makeFloors(new TestLineSourceGenerator(List.of(
                I_____I,
                IxxxxxI
        )));
        assertAll(
                () -> {
                    assertThat(ladder.resultPositionOf(0)).isEqualTo(1);
                },
                () -> {
                    assertThat(ladder.resultPositionOf(1)).isEqualTo(0);
                }
        );
    }

    @Test
    @DisplayName("3명으로 구성된 3층 사다리 테스트")
    void testForBridge() {
        final Users users = new Users(List.of("a", "b", "c"));
        final Ladder ladder = new Ladder(3, 3);
        ladder.makeFloors(new TestLineSourceGenerator(List.of(
                I_____I, IxxxxxI,
                IxxxxxI, I_____I,
                IxxxxxI, IxxxxxI
        )));

        assertAll(
                () -> {
                    assertThat(ladder.resultPositionOf(0)).isEqualTo(2);
                },
                () -> {
                    assertThat(ladder.resultPositionOf(1)).isEqualTo(0);
                },
                () -> {
                    assertThat(ladder.resultPositionOf(2)).isEqualTo(1);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 4, 5, 6})
    @DisplayName("사다리 크기에 맞지 않는 위치의 최종 위치값 반환 함수를 호출하면 예외를 발생시킨다.")
    void resultPositionExceptionTest(int index) {
        final Ladder ladder = new Ladder(2, 3);
        assertThatThrownBy(() -> ladder.resultPositionOf(index))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 위치는 존재하지 않는 값입니다.");
    }

}
