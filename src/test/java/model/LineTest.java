package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ThresholdChecker;


public class LineTest {


    @Test
    @DisplayName("왼쪽으로 인접한 가로 라인을 확인한다.")
    void adjacentTest() {
        //given
        Line line=new Line(() -> true, 4);
        line.draw(() -> true, 4);

        //when
        List<Boolean> expect=List.of(false, true, false, true);
        List<Boolean> actual = new ArrayList<>();
        for(int i=0;i<4;i++){
            actual.add(line.hasLeftConnectedLine(i));
        }

        //then
        assertThat(actual).isEqualTo(expect);
    }
    @Test
    @DisplayName("우측으로 가로 라인이 있는 위치들을 반환한다")
    void findHorizontalTest() {
        //given
        Line line=new Line(() -> true, 4);
        line.draw(() -> true, 4);

        //when
        List<Integer> expect=List.of(0,2);
        List<Integer> actual = line.findHorizontalPosition();

        //then
        assertThat(expect).isEqualTo(actual);
    }

    @Test
    @DisplayName("특정 위치를 지정하면 이동할 방향을 정해준다.")
    void showDirectionTest() {
        //given
        Line line = new Line(() -> true, 4);

        //when
        Direction leftDirection = line.showDirection(1);
        Direction rightDirection = line.showDirection(2);

        //then
        assertThat(leftDirection).isEqualTo(Direction.LEFT);
        assertThat(rightDirection).isEqualTo(Direction.RIGHT);
    }

    @Nested
    @DisplayName("접근제어자 없이 테스트 하기 위한 학습용 코드")
    class accessModifierTest{

        @Test
        @DisplayName("리플랙션을 통한 테스트 방법")
        void reflectionTest() throws Exception {
            //given
            ThresholdChecker thresholdChecker = () -> true;
            Line line = new Line(() -> true, 5);

            //when
            Method makeHorizontalLine = line.getClass()
                    .getDeclaredMethod("makeHorizontalLine", ThresholdChecker.class, int.class);
            makeHorizontalLine.setAccessible(true);

            makeHorizontalLine.invoke(line, thresholdChecker,4);

            //then
            assertThat(line.hasLeftConnectedLine(5))
                    .isTrue();
        }

        @ParameterizedTest
        @ValueSource(ints = {1,3})
        @DisplayName("private Method를 커버하는 public Method에 대한 테스트를 한다.")
        void parameterizedTest(int position) {
            //given
            Line line = new Line(()-> true, 5);

            //when
            line.draw(() -> true, 5);

            //then
            assertThat(line.hasLeftConnectedLine(position))
                    .isTrue();
         }


        @ParameterizedTest
        @ValueSource(ints = {0,2,4})
        @DisplayName("private Method를 커버하는 public Method에 대한 실패 테스트도 한다.")
        void parameterizedFailedTest(int position) {
            //given
            Line line = new Line(()-> true, 5);

            //when
            line.draw(() -> true, 5);

            //then
            assertThat(line.hasLeftConnectedLine(position))
                    .isFalse();
        }
    }

}
