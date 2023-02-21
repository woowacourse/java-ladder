package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionTest {

    @Test
    void 현재_위치의_왼쪽을_알_수_있다() {
        Position position = new Position(1);

        assertThat(position.left().getPosition()).isEqualTo(0);
    }

    @Test
    void 현재_위치의_오른쪽을_알_수_있다() {
        Position position = new Position(1);

        assertThat(position.right().getPosition()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"0,1,true", "1,1,true", "1,2,true", "2,3,false"})
    void 두_위치_사이에_있는지_알_수_있다(int fromInclusive, int toInclusive, boolean isInBetween) {
        Position position = new Position(1);
        assertThat(position.isInBetween(fromInclusive, toInclusive)).isEqualTo(isInBetween);
    }
}
