package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineStateTest {

    @DisplayName("true로 LineState를 생성하면 START를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"true,START", "false,NONE"})
    void decideFirstLineState(boolean decision, LineState expected) {
        LineState actual = LineState.decideFirstLineState(decision);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("이전 State가 START이면 END를 반환하고 이외에는 boolean 값에 따라 결과를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"START,true,END", "START,false,END", "NONE,true,START", "END,false,NONE"})
    void decideMiddleLineState(LineState beforeState, boolean givenDecision, LineState expectedState) {
        LineState actual = LineState.decideMiddleLineState(beforeState, givenDecision);
        assertThat(actual).isEqualTo(expectedState);
    }

    @DisplayName("이전 State가 START이면 END를 반환하고 이외에는 NONE을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"START,END", "END,NONE", "NONE,NONE"})
    void decideLastLineState(LineState beforeState, LineState expectedState) {
        LineState actual = LineState.decideLastLineState(beforeState);
        assertThat(actual).isEqualTo(expectedState);
    }

    @DisplayName("조회한 State에 해당하는 방향 int 값을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"START,1", "END,-1", "NONE,0"})
    void findStateDirection(LineState state, int directionIndex) {
        assertThat(LineState.findDirection(state)).isEqualTo(directionIndex);
    }
}

