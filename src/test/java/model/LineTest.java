package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class LineTest {

    @Test
    @DisplayName("우측으로 가로 라인이 있는 위치들을 반환한다")
    void findHorizontalTest() {
        //given
        Line line = new Line(() -> true, 4);
        line.draw(() -> true, 4);

        //when
        List<Integer> expect = List.of(0, 2);
        List<Integer> actual = line.findHorizontalPosition();

        //then
        assertThat(expect).isEqualTo(actual);
    }

    @Nested
    @DisplayName("특정 위치를 지정하면 이동 할수 있는 가로 위치를 반환한다.")
    class findDirectionTest {
        @ParameterizedTest
        @ValueSource(ints = {0, 2})
        @DisplayName("오른쪽에 가로라인이 있는 위치를 지정하면 오른쪽 방향을 반환한다.")
        void findRightDirectionTest(int horizontalIndex) {
            //given
            Line line = new Line(() -> true, 4);

            //when
            Direction direction = line.findDirection(horizontalIndex);

            //then
            assertThat(direction).isEqualTo(Direction.RIGHT);
        }

        @ParameterizedTest
        @ValueSource(ints = {1})
        @DisplayName("왼쪽에 가로라인이 있는 위치를 지정하면 왼쪽 방향을 반환한다.")
        void findLeftDirectionTest(int horizontalIndex) {
            //given
            Line line = new Line(() -> true, 4);

            //when
            Direction direction = line.findDirection(horizontalIndex);

            //then
            assertThat(direction).isEqualTo(Direction.LEFT);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2})
        @DisplayName("양쪽 모두 가로라인이 없는 경우에도 위치를 반환한다.")
        void findNoneDirectionTest(int horizontalIndex) {
            //given
            Line line = new Line(() -> false, 4);

            //when
            Direction direction = line.findDirection(horizontalIndex);

            //then
            assertThat(direction)
                    .isEqualTo(Direction.NONE);
        }
    }

}
