package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    private static List<Line> getFloorLines(int pos, Ladder ladder) {
        return ladder.getFloors().get(pos - 1).getLines();
    }

    @Test
    @DisplayName("0이하의 값으로 Ladder생성시 예외가 발생한다.")
    void inValidLadderSizeTest() {
        assertThatThrownBy(() -> new Ladder(0, new Users(List.of("1", "2"))))
                .isInstanceOf(IllegalArgumentException.class);
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
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(List.of(1, 0, 1));

        Ladder ladder = new Ladder(1, new Users(List.of("1", "2", "3", "4")));
        ladder.makeFloors(testNumberGenerator);

        assertThat(ladder.getFloors().get(0).getLines())
                .extracting("isExist")
                .containsExactlyElementsOf(List.of(true, false, true));

    }

    @Test
    @DisplayName("Ladder 생성 테스트")
    void makeFloorTest() {
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(List.of(1, 0, 0, 1, 1, 1));

        Ladder ladder = new Ladder(2, new Users(List.of("1", "2", "3", "4")));
        ladder.makeFloors(testNumberGenerator);

        assertThat(ladder.getFloors().get(0).getLines())
                .extracting("isExist")
                .containsExactlyElementsOf(List.of(true, false, false));

        assertThat(ladder.getFloors().get(1).getLines())
                .extracting("isExist")
                .containsExactlyElementsOf(List.of(true, false, true));


    }

}
