package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

        int peopleCount = 3;
        Line line = new Line(peopleCount, List.of(true, true, false));

        List<LineState> lineStates = line.getLineStates();
        LineState lineState = lineStates.get(1);

        assertThat(lineState).isEqualTo(expected);
    }

    @DisplayName("이전 상태가 START가 아닐 경우 현재 상태는 true면 START false면 NONE이다.")
    @ParameterizedTest
    @CsvSource(value = {"true,START", "false,NONE"})
    void initializeLineStateWhenBeforeStateNotStart(boolean given, LineState expected) {
        int peopleCount = 3;
        Line line = new Line(peopleCount, List.of(false, given, false));

        List<LineState> lineStates = line.getLineStates();
        LineState lineState = lineStates.get(1);

        assertThat(lineState).isEqualTo(expected);
    }

    @DisplayName("총 참여자 수와 랜덤 생성된 불린 값의 크기가 같지 않을 경우 예외가 발생한다.")
    @Test
    void validateIllegalInputException() {

        int peopleCount = 3;
        assertThatThrownBy(() -> new Line(peopleCount, List.of(false, false, false, true)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 랜덤 값 생성 개수가 총 참여자 수와 일치하지 않습니다.");

    }

}
