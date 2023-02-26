package domain;

import exception.InvalidLineWeightException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.RandomBooleanGenerator;

import java.util.List;

class LineTest {

    @DisplayName("라인의 너비가 조건에 맞을 경우 객체를 생성한다.")
    @Test
    void createSuccess() {
        Line line = new Line(9, new RandomBooleanGenerator());
        List<LineStatus> weight = line.getStatus();
        Assertions.assertThat(weight)
                  .hasSize(9);
    }

    @DisplayName("라인의 너비가 9을 넘을 경우 오류를 던진다.")
    @Test
    void weightOverNine() {
        Assertions.assertThatThrownBy(() -> new Line(10, new RandomBooleanGenerator()))
                  .isExactlyInstanceOf(InvalidLineWeightException.class);
    }

    @DisplayName("라인의 너비가 1보다 작을 경우 오류를 던진다.")
    @Test
    void weightUnderOne() {
        Assertions.assertThatThrownBy(() -> new Line(0, new RandomBooleanGenerator()))
                  .isExactlyInstanceOf(InvalidLineWeightException.class);
    }

    @DisplayName("라인이 정상적으로 생성된 경우. (전부 비연결)")
    @Test
    void makeStatusCheckAllFalse() {
        Line line = new Line(3, () -> false);
        Assertions.assertThat(line.getStatus())
                  .containsExactly(LineStatus.DISCONNECTED,
                          LineStatus.DISCONNECTED, LineStatus.DISCONNECTED);
    }

    @DisplayName("라인은 정상적으로 생성된 경우. (연결가능 부분 연결)")
    @Test
    void makeStatusCheck() {
        Line line = new Line(3, () -> true);
        Assertions.assertThat(line.getStatus())
                  .containsExactly(LineStatus.CONNECTED,
                          LineStatus.DISCONNECTED, LineStatus.CONNECTED);
    }

    @DisplayName("왼쪽으로 움직일 수 있는지에 따른 결과 확인")
    @ParameterizedTest
    @CsvSource({"0, false", "1, true", "2, false"})
    void canMoveLeft(int index, boolean expect) {
        Line line = new Line(2, () -> true);
        Assertions.assertThat(line.canMoveLeft(index))
                  .isEqualTo(expect);
    }

    @DisplayName("왼쪽으로 움직일 수 있는지에 따른 결과 확인")
    @ParameterizedTest
    @CsvSource({"0, true", "1, false", "2, false"})
    void canMoveRight(int index, boolean expect) {
        Line line = new Line(2, () -> true);
        Assertions.assertThat(line.canMoveRight(index))
                  .isEqualTo(expect);
    }
}
