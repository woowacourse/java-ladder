package domain.model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;


public class LineTest {


    @Test
    @DisplayName("왼쪽으로 인접한 가로 라인을 확인한다.")
    void adjacentTest() {
        //given
        Line line=new Line(() -> 5, 4);
        line.draw(() -> 5, 4);
        //when
        List<Boolean> expect=List.of(false, true, false, true);
        List<Boolean> actual = new ArrayList<>();
        for(int i=0;i<4;i++){
            actual.add(line.hasLeftConnectedLine(i));
        }
        //then
        Assertions.assertThat(actual).isEqualTo(expect);
    }
    @Test
    @DisplayName("우측으로 가로 라인이 있는 위치들을 반환한다")
    void findHorizontalTest() {
        //given
        Line line=new Line(() -> 5, 4);
        line.draw(() -> 5, 4);
        //when
        List<Integer> expect=List.of(0,2);
        List<Integer> actual = line.findHorizontal();
        //then
        Assertions.assertThat(expect).isEqualTo(actual);
    }

}
