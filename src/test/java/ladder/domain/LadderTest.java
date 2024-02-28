package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("입력받은 높이만큼 사다리의 라인을 생성한다.")
    void createLadder() {
        // given
        Height height = new Height("5");
        People people = new People("pobi,honux,crong,jk");

        // when
        Ladder ladder = new Ladder(people, height);

        // then
        assertThat(ladder.getLadder()).hasSize(5);
    }

    @DisplayName("특정 참여자의 사다리를 실행한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 3", "2, 2", "3, 1"})
    void climb(int index, int actual) {
        // given
        /*
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
         */
        Ladder ladder = new Ladder(
                new Line(Point.USED, Point.UNUSED, Point.USED, Point.UNUSED),
                new Line(Point.UNUSED, Point.USED, Point.UNUSED, Point.UNUSED),
                new Line(Point.USED, Point.UNUSED, Point.UNUSED, Point.UNUSED),
                new Line(Point.UNUSED, Point.USED, Point.UNUSED, Point.UNUSED),
                new Line(Point.USED, Point.UNUSED, Point.USED, Point.UNUSED)
        );

        // when
        int expected = ladder.execute(index);

        // then
        assertThat(expected).isEqualTo(actual);
    }
}
