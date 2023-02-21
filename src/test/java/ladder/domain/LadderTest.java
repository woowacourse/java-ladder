package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    private final LineSource make = LineSource.MAKE_LINE;
    private final LineSource blank = LineSource.MAKE_BLANK;

    private static List<Line> getFloorLines(int pos, Ladder ladder) {
        return ladder.getFloors().get(pos - 1).getLines();
    }

    @Test
    @DisplayName("0이하의 값으로 Ladder생성시 예외가 발생한다.")
    void inValidLadderSizeTest() {
        assertThatThrownBy(() -> new Ladder(0, new Users(List.of("1", "2"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1이상 입니다.");
    }

    @Test
    @DisplayName("1이상의 값으로 Ladder생성 시 사이즈 테스트")
    void checkValidLadderSizeTest() {
        assertThat(new Ladder(3, new Users(List.of("1", "2"))).getFloors().size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("Ladder 가로 사이즈 테스트")
    void checkLadderWidthTest() {
        Ladder ladder = new Ladder(3, new Users(List.of("1", "2", "3")));
        List<Floor> floors = ladder.getFloors();

        for (Floor floor : floors) {
            assertThat(floor.getLines().size()).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("Ladder 1층 생성 테스트")
    void makeFirstFloorTest() {
        TestLineSourceGenerator testLineSourceGenerator = new TestLineSourceGenerator(List.of(make, blank, blank));

        Ladder ladder = new Ladder(1, new Users(List.of("1", "2", "3", "4")));
        ladder.makeFloors(testLineSourceGenerator);

        List<Line> firstFloorLines = getFloorLines(1, ladder);

        assertThat(firstFloorLines.get(0).isExist()).isEqualTo(true);
        assertThat(firstFloorLines.get(1).isExist()).isEqualTo(false);
        assertThat(firstFloorLines.get(2).isExist()).isEqualTo(false);
    }

    @Test
    @DisplayName("Ladder 생성 테스트")
    void makeFloorTest() {
        TestLineSourceGenerator testLineSourceGenerator = new TestLineSourceGenerator(List.of(make, blank, blank, make, make, make));

        Ladder ladder = new Ladder(2, new Users(List.of("1", "2", "3", "4")));
        ladder.makeFloors(testLineSourceGenerator);

        List<Line> firstFloorLines = getFloorLines(1, ladder);
        List<Line> secondFloorLines = getFloorLines(2, ladder);

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
        final Ladder ladder = new Ladder(8, users);
        ladder.makeFloors(new TestLineSourceGenerator(List.of(LineSource.MAKE_BLANK)));
        for (int i = 0; i < users.size(); i++) {
            assertThat(ladder.resultPositionOf(i)).isEqualTo(i);
        }
    }

}
