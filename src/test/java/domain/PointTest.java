package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {


    @Test
    @DisplayName("Point가 양쪽으로 연결 되어 있으면 예외가 발생한다")
    void biDirectionConnectivity() {
        assertThatCode(() -> new Point(true, true)).isInstanceOf(IllegalArgumentException.class);
    }
}
