package domain.model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static domain.model.Direction.*;

public class LineTest {


    @Test
    @DisplayName("인접한 가로 라인을 확인한다.")
    void adjacentTest() {
        //given
        Line line=new Line(4);
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
}
