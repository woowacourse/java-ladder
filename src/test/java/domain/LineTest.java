package domain;

import helper.AbstractTestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest extends AbstractTestFixture {

    @Test
    @DisplayName("3개의 브릿지가 연속될 경우 IllegalArgumentException을 반환한다")
    void test_sameHeight1_IllegalArgumentException() {

        testAssertThrowsIllegalArgumentException(convert(true, true, false));
    }

    @Test
    @DisplayName("3개의 브릿지가 연속될 경우 IllegalArgumentException을 반환한다")
    void test_sameHeight2_IllegalArgumentException() {

        testAssertThrowsIllegalArgumentException(convert(false, true, true));
    }

    @Test
    @DisplayName("3개의 브릿지가 연속될 경우 IllegalArgumentException을 반환한다")
    void test_sameHeight3_IllegalArgumentException() {

        testAssertThrowsIllegalArgumentException(convert(true, true, true));
    }

    @Test
    @DisplayName("3개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight1_IllegalArgumentException() {

        testAssertNotThrowsException(convert(true, false, true));
    }

    @Test
    @DisplayName("3개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight2_IllegalArgumentException() {

        testAssertNotThrowsException(convert(false, true, false));
    }

    @Test
    @DisplayName("4개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight3_IllegalArgumentException() {

        testAssertNotThrowsException(convert(true, false, false, true));
    }

    @Test
    @DisplayName("1개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight4_IllegalArgumentException() {

        testAssertNotThrowsException(convert(true));
    }

    private void testAssertThrowsIllegalArgumentException(List<Bridge> bridges) {
        assertThatThrownBy(() -> new Line(bridges))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void testAssertNotThrowsException(List<Bridge> bridges) {
        assertThatNoException().isThrownBy(
                () -> new Line(bridges)
        );
    }
}
