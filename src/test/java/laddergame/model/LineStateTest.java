package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineStateTest {
    @DisplayName("불린 값으로 LineState를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"true,START", "false,NONE"})
    void decideLineStateWithBoolean(boolean decision, LineState expected) {
        LineState actual = LineState.decideLineState(decision);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("이전 LineState로 다음 LineState를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"START,END", "END,NONE", "NONE,NONE"})
    void decideLineStateWithBeforeState(LineState beforeState, LineState expected) {
        LineState actual = LineState.decideLineState(beforeState);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("이전 LineState와 불린 값으로 LineState를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"START,true,END", "START,false,END", "NONE,true,START", "END,false,NONE"})
    void decideLineStateWithBeforeState(LineState beforeState, boolean given, LineState expected) {
        LineState actual = LineState.decideLineState(beforeState, given);
        assertThat(actual).isEqualTo(expected);
    }
}
