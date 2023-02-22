package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import helper.AbstractTestFixture;

class LineTest extends AbstractTestFixture {

    @ParameterizedTest(name = "브릿지가 연속될 경우 IllegalArgumentException을 던진다")
    @CsvSource(value = {"true,true,false", "false,true,true", "true,true,true"})
    void test_serial_IllegalArgumentException(boolean firstBridge, boolean secondBridge, boolean thirdBridge) {
        assertThatThrownBy(() -> new Line(convert(firstBridge, secondBridge, thirdBridge)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "연속되지 않는 브릿지들로 Line을 생성한다")
    @CsvSource(value = {"true,false,true", "false,true,false"})
    void test_notSerial_success(boolean firstBridge, boolean secondBridge, boolean thirdBridge) {
        assertThatNoException()
                .isThrownBy(() -> new Line(convert(firstBridge, secondBridge, thirdBridge)));
    }

    @Test
    @DisplayName("연속되지 않는 4개의 브릿지들로 Line을 생성한다")
    void test_notSerial_4_success() {
        assertThatNoException()
                .isThrownBy(() -> new Line(convert(true, false, false, true)));
    }

    @Test
    @DisplayName("1개의 브릿지로 Line을 생성한다")
    void test_notSerial_1_success() {
        assertThatNoException()
                .isThrownBy(() -> new Line(convert(true)));
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,0", "2,2", "3,4", "4,3", "5,5"})
    void 현재_위치에서_이동할_다음_위치를_알_수_있다(int currentPosition, int expectedNextPosition) {
        Line line = new Line(convert(true, false, false, true, false));

        assertThat(line.moveFrom(new Position(currentPosition))).isEqualTo(new Position(expectedNextPosition));
    }
}
