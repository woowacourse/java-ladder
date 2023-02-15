package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineCreatorTest {

    @Test
    void throwExceptionWhenBooleanGeneratorIsNull() {
        BooleanGenerator generator = null;
        Assertions.assertThatThrownBy(()->new LineCreator(generator));
    }
}