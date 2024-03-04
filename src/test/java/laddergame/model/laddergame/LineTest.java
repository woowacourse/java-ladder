package laddergame.model.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import laddergame.exception.BaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LineTest {
    @DisplayName("첫 인덱스가 END이거나 마지막 인덱스가 START이면 예외를 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"END,END", "END,START", "START,START"})
    void validateStartWithEndOrEndsWithStart(LineState first, LineState end) {
        //given
        List<LineState> lineStates = List.of(
                first,
                LineState.START,
                LineState.END,
                end
        );
        //when //then
        assertThatThrownBy(() -> new Line(lineStates))
                .isInstanceOf(BaseException.class);
    }

    @DisplayName("START나 END가 연속되면 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("generateContinuousState")
    void validateContinuousStartOrEnd(List<LineState> given) {
        //when //then
        assertThatThrownBy(() -> new Line(given))
                .isInstanceOf(BaseException.class);
    }

    @DisplayName("START이면 index는 증가하고 END이면 index는 감소한다.")
    @Test
    void move() {
        //given
        List<LineState> lineStates = List.of(
                LineState.START,
                LineState.END,
                LineState.NONE
        );
        Line line = new Line(lineStates);
        //when //then
        assertAll(
                () -> assertThat(line.move(0)).isEqualTo(1),
                () -> assertThat(line.move(1)).isEqualTo(0),
                () -> assertThat(line.move(2)).isEqualTo(2)
        );
    }

    private static Stream<Arguments> generateContinuousState() {
        return Stream.of(
                Arguments.arguments(List.of(
                        LineState.START,
                        LineState.START,
                        LineState.END
                )),
                Arguments.arguments(List.of(
                        LineState.START,
                        LineState.END,
                        LineState.END
                ))
        );
    }
}
