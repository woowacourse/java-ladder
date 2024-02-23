package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {
    @DisplayName("이전 상태가 START이면 END이다. 아닐 경우 true면 S false면 N이다.")
    @Test
    void initializeLineStateWhenBeforeStateIsStart() {
        LineState expected = LineState.END;

        int peopleCount = 3;
        Line line = new Line(peopleCount, List.of(true, true, false));

        List<LineState> lineStates = line.getLineStates();
        LineState lineState = lineStates.get(1);

        assertThat(lineState).isEqualTo(expected);
    }

    @DisplayName("이전 상태가 S가 아닐 경우 true면 S false면 N이다.")
    @ParameterizedTest
    @CsvSource(value = {"true,START", "false,NONE"})
    void initializeLineStateWhenBeforeStateNotStart(boolean given, LineState expected) {
        int peopleCount = 3;
        Line line = new Line(peopleCount, List.of(false, given, false));

        List<LineState> lineStates = line.getLineStates();
        LineState lineState = lineStates.get(1);

        assertThat(lineState).isEqualTo(expected);
    }
}
