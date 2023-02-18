package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("라인")
class LineTest {

    List<Boolean> given;

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
        assertThatThrownBy(()->new Line(given));
    }

    @DisplayName("가로 라인이 겹치면 예외가 발생한다.")
    @Test
    void throwExceptionWhenBothTrue() {
        //given
        given = List.of(true, true, false);
        //when
        //then
        assertThatThrownBy(()-> new Line(given));
    }
}
