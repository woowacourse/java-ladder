package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("사다리의 포인트가 true인 지점은 연속될 수 없다.")
    @Test
    void pointNotContinuous() {
        int pointSize = 5;
        Line line = new Line(pointSize);
        for (int i = 0; i < pointSize - 1; i++) {
            boolean left = line.getPointAt(i);
            boolean right = line.getPointAt(i + 1);
            assertThat(left && right).isFalse();
        }
    }

    @Test
    void test() {
        boolean[] arr = new boolean[10];
        Arrays.fill(arr, false);
        System.out.println(arr[0]);
    }
}
