import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("사다리의 열은 참가자의 수보다 하나 적다.")
    @Test
    void lengthOfLine() {
        int participantSize = 5;
        Line line = new Line(participantSize);
        assertThat(line.getMaxSize())
                .isEqualTo(participantSize - 1);
    }


    @DisplayName("행 내부의 라인이 겹치지 않도록 사다리를 생성할 수 있다.")
    @Test
    void cross() {
        Line line = new Line(6);
        line.cross(true);
        line.cross(true);
        line.cross(true);
        assertThat(line.getPoints()).isEqualTo(List.of(true,false,true,false,true));
    }


}
