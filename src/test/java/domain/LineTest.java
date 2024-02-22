package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LineTest {

    /* TODO
    @Test
    @DisplayName("true-true 쌍이 발견될 경우 에러를 반환한다.")
    void test_exception_findTrueTrue() {
    }
     */

    @RepeatedTest(1000)
    @DisplayName("랜덤으로 만든 값이 true 또는 false이다.")
    void test() {
        Line line = new Line();
        line.getPoints().forEach(
                point -> assertThat(point).isInstanceOf(Boolean.class));
    }

    @Test
    @DisplayName("true가 나오면 그 다음은 무조건 false가 된다.")
    void test_ok_trueNextFalse() {
        Line line = new Line() {
            @Override
            boolean makeRandomBoolean() {
                return true;
            }
        };
        assertThat(line.getPoints().get(1)).isFalse();
    }
}
