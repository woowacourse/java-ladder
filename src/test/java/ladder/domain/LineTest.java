package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 특정_위치의_사다리_연결_기능_테스트() {
        Line line = new Line(new Height(3));
        line.connectHeight(1);
        Assertions.assertThat(line.getByHeight(1)).isTrue();
    }

}