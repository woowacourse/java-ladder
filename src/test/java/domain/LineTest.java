package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("3개의 브릿지가 연속될 경우 IllegalArgumentException을 반환한다")
    void test_sameHeight1_IllegalArgumentException() {

        assertThatThrownBy(() -> new Line(List.of(true, true, false)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3개의 브릿지가 연속될 경우 IllegalArgumentException을 반환한다")
    void test_sameHeight2_IllegalArgumentException() {

        assertThatThrownBy(() -> new Line(List.of(false, true, true)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3개의 브릿지가 연속될 경우 IllegalArgumentException을 반환한다")
    void test_sameHeight3_IllegalArgumentException() {

        assertThatThrownBy(() -> new Line(List.of(true, true, true)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight1_IllegalArgumentException() {

        assertThatNoException().isThrownBy(() -> new Line(List.of(true, false, true)));
    }

    @Test
    @DisplayName("3개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight2_IllegalArgumentException() {

        assertThatNoException().isThrownBy(() -> new Line(List.of(false, true, false)));
    }

    @Test
    @DisplayName("4개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight3_IllegalArgumentException() {

        assertThatNoException().isThrownBy(() -> new Line(List.of(true, false, false, true)));
    }

    @Test
    @DisplayName("1개의 브릿지가 연속되지 않으면 성공적으로 사다리가 생성된다")
    void test_notSameHeight4_IllegalArgumentException() {

        assertThatNoException().isThrownBy(() -> new Line(List.of(true)));
    }
}
