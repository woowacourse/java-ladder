package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    static Ladder ladder;

    @BeforeAll
    static void makeLadder() {
        ladder = new Ladder(() -> true, "3", 4);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0", "0,2",
            "1,0", "1,2",
            "2,0", "2,2",})
    @DisplayName("특정 위치에서 가로로 이동 가능한 위치가 오른쪽인 경우")
    void findRightNextPathTest(int verticalPosition, int horizontalPosition) {
        //when
        Direction direction = ladder.findNextHorizontalPath(horizontalPosition, verticalPosition);

        //then
        assertThat(direction)
                .isEqualTo(Direction.RIGHT);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1", "0,3",
            "1,1", "1,3",
            "2,1", "2,3",})
    @DisplayName("특정 위치에서 가로로 이동 가능한 위치가 왼쪽인 경우")
    void findLeftNextPathTest(int verticalPosition, int horizontalPosition) {
        //when
        Direction direction = ladder.findNextHorizontalPath(horizontalPosition, verticalPosition);

        //then
        assertThat(direction)
                .isEqualTo(Direction.LEFT);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0", "0,1", "0,2", "0,3",
            "1,0", "1,1", "1,2", "1,3",
            "2,0", "2,1", "2,2", "2,3"})
    @DisplayName("특정 위치에서 가로로 이동 가능한 위치가 없는 경우")
    void findNoneNextPathTest(int verticalPosition, int horizontalPosition) {
        //given
        Ladder emptyLadder = new Ladder(() -> false, "3", 5);

        //when
        Direction direction = emptyLadder.findNextHorizontalPath(horizontalPosition, verticalPosition);

        //then
        assertThat(direction)
                .isEqualTo(Direction.NONE);
    }
}
