package util;

import domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static util.Connection.CONNECTED;
import static util.Connection.UNCONNECTED;

public class LineStringTest {

    @DisplayName("Line의 상태를 String으로 반환한다.")
    @Test
    void LineToStringTest() {
        Line line = new Line(List.of(4, 5, 4, 5, 4));
        Assertions.assertThat(LineString.from(line))
                .isEqualTo(UNCONNECTED.getBridge()
                        + CONNECTED.getBridge()
                        + UNCONNECTED.getBridge()
                        + CONNECTED.getBridge()
                        + UNCONNECTED.getBridge()
                        );
    }
}
