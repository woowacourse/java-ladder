package laddergame.domain.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DestinationTest {
    Destination destination;

    @BeforeEach
    public void setUp() {
        destination = new Destination("꽝");
    }

    @Test
    public void 객체_생성_검사() {
        assertThat(destination).isEqualTo(new Destination("꽝"));
    }

    @Test
    public void 공백문자들로_객체를_생성했을때_예외발생하는지_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Destination("500000");
        });
    }

}