package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import laddergame.domain.ladder.line.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("라인")
class LineTest {

    private List<Boolean> given;

    @DisplayName("생성된다.")
    @Test
    void create() {
        //given
        given = List.of(true, false, true);

        //when
        //then
        assertDoesNotThrow(() -> new Line(given));
    }

    @DisplayName("가로 라인이 겹치지 않으면 생성된다.")
    @Test
    void createWithBothFalse() {
        //given
        given = List.of(false, false, true);
        //when
        //then
        assertDoesNotThrow(() -> new Line(given));
    }

    @DisplayName("포인트가 비어 있으면 예외가 발생한다.")
    @Test
    void throwExceptionWhenPointsIsEmpty() {
        //given
        given = List.of();
        //when
        //then
        assertThatThrownBy(() -> new Line(given));
    }

    @DisplayName("인덱스로 rungExistsAtColumn 의 원소를 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void success(int index) {
        //given
        List<Boolean> values = List.of(true, false, true);
        Line line = new Line(values);
        //when
        boolean value = line.isPointFilledAt(index);
        Assertions.assertThat(value).isEqualTo(values.get(index));
    }

    @DisplayName("인덱스가 범위를 벗어날 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4, 100})
    void throwExceptionWhenIndexOutOfRange(int index) {
        //given
        List<Boolean> values = List.of(true, false, true);
        Line line = new Line(values);
        //when
        assertThatThrownBy(() -> line.isPointFilledAt(index))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
