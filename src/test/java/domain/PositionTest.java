package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("position 객체는 필드의 값만 같으면 같은 객체다")
    void positionIdentifyByFieldValue() {
        final Position position = new Position(10);

        Assertions.assertThat(position).isEqualTo(new Position(10));
    }
}
