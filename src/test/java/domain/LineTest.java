package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("라인의 포인트 개수는 20을 넘을 수 없다.")
    @Test
    void pointNotMoreThan20() {
        int pointSize = 21;
        assertThatThrownBy(() -> {
            new Line(pointSize);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인의 포인트 개수는 0이하일 수 없다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void pointNotLessThan1(int pointSize) {
        assertThatThrownBy(() -> {
            new Line(pointSize);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
