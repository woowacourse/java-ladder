package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("라인")
class LineTest {

    @DisplayName("생성된다.")
    @Test
    void create() {
        assertDoesNotThrow(() -> new Line(List.of(true, false, true)));
    }

    @DisplayName("가로 라인이 겹치지 않으면 생성된다.")
    @Test
    void createWithBothFalse() {
        assertDoesNotThrow(() -> new Line(List.of(false, false, true)));
    }

    @DisplayName("포인트가 비어 있으면 예외가 발생한다.")
    @Test
    void throwExceptionWhenPointsIsEmpty() {
        assertThatThrownBy(()->new Line(List.of()));
    }

    @DisplayName("가로 라인이 겹치면 예외가 발생한다.")
    @Test
    void throwExceptionWhenBothTrue() {
        assertThatThrownBy(()-> new Line(List.of(true, true, false)));
    }
}