package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {


    @Test
    @DisplayName("Point가 양쪽으로 연결 되어 있으면 예외가 발생한다")
    void biDirectionConnectivity() {
        assertThatCode(() -> new Point(true, true)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"true,false,-1", "false,true,1", "false,false,0"})
    @DisplayName("왼쪽 혹은 오른쪽의 연결에 따라 이동한다")
    void move(final boolean left, final boolean right, final int expected) {
        Point point = new Point(left, right);

        assertThat(point.move()).isEqualTo(expected);
    }
}
