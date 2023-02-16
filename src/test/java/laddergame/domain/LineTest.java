package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LineTest {
    @Test
    void create() {
        assertDoesNotThrow(() -> new Line(List.of(true, false, true)));
    }

    @Test
    void createWithBothFalse() {
        assertDoesNotThrow(() -> new Line(List.of(false, false, true)));
    }

    @Test
    void throwExceptionWhenPointsIsEmpty() {
        assertThatThrownBy(()->new Line(List.of()));
    }

    @Test
    void throwExceptionWhenBothTrue() {
        assertThatThrownBy(()-> new Line(List.of(true, true, false)));
    }
}