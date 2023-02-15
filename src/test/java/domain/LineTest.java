package domain;

import helper.AbstractTestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest extends AbstractTestFixture {

    @Test
    @DisplayName("3개의 브릿지가 연속될 경우 IllegalArgumentException을 반환한다")
    void test_sameHeight1_IllegalArgumentException() {

        assertThatThrownBy(() -> new Line(convert(true, true, false)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3개의 브릿지가 연속될 경우 IllegalArgumentException을 반환한다")
    void test_sameHeight2_IllegalArgumentException() {

        assertThatThrownBy(() -> new Line(convert(false, true, true)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3개의 브릿지가 연속될 경우 IllegalArgumentException을 반환한다")
    void test_sameHeight3_IllegalArgumentException() {

        assertThatThrownBy(() -> new Line(convert(true, true, true)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight1_IllegalArgumentException() {

        assertThatNoException().isThrownBy(() -> new Line(convert(true, false, true)));
    }

    @Test
    @DisplayName("3개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight2_IllegalArgumentException() {

        assertThatNoException().isThrownBy(() -> new Line(convert(false, true, false)));
    }

    @Test
    @DisplayName("4개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight3_IllegalArgumentException() {

        assertThatNoException().isThrownBy(() -> new Line(convert(true, false, false, true)));
    }

    @Test
    @DisplayName("1개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight4_IllegalArgumentException() {

        assertThatNoException().isThrownBy(() -> new Line(convert(true)));
    }
}
