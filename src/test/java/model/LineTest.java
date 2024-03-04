package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {

    @DisplayName("이전 상태가 START이면 현재 상태는 END이다.")
    @Test
    void initializeLineStateWhenBeforeStateIsStart() {
        LineState expected = LineState.END;
        List<Boolean> determineLungExists = List.of(true, false, false);
        Line line = new Line(determineLungExists);

        List<LineState> lineStates = line.getLineStates();
        LineState lineState = lineStates.get(1);

        assertThat(lineState).isEqualTo(expected);
    }

    @DisplayName("이전 상태가 START가 아닐 경우 현재 상태는 true면 START false면 NONE이다.")
    @ParameterizedTest
    @CsvSource(value = {"true,START", "false,NONE"})
    void initializeLineStateWhenBeforeStateNotStart(boolean given, LineState expected) {
        List<Boolean> determineLungExists = List.of(false, given, false);
        Line line = new Line(determineLungExists);

        List<LineState> lineStates = line.getLineStates();
        LineState lineState = lineStates.get(1);

        assertThat(lineState).isEqualTo(expected);
    }

    @DisplayName("라인의 state가 START이면 위치를 오른쪽으로 1칸 이동한다.")
    @Test
    void moveRight() {
        List<Boolean> determineLungExists = List.of(true, false);
        Line line = new Line(determineLungExists);

        int index = 0;
        index = line.move(index);

        assertThat(index).isEqualTo(1);
    }

    @DisplayName("라인의 state가 END면 위치를 왼쪽으로 1칸 이동한다.")
    @Test
    void moveLeft() {
        List<Boolean> determineLungExists = List.of(true, false);
        Line line = new Line(determineLungExists);

        int index = 1;
        index = line.move(index);

        assertThat(index).isEqualTo(0);
    }

    @DisplayName("라인의 state가 NONE이면 위치를 변경하지 않는다.")
    @Test
    void moveNowhere() {
        List<Boolean> determineLungExists = List.of(false, false);
        Line line = new Line(determineLungExists);

        int index = 0;
        index = line.move(index);

        assertThat(index).isEqualTo(0);
    }
}
