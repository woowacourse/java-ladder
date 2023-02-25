package ladder.domain.generator;

import ladder.domain.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomDirectionGeneratorTest {

    @Test
    @DisplayName("랜덤한 범위의 값을 제대로 생성하는지 확인한다")
    void validRandomDirection() {
        // given
        final DirectionGenerator directionGenerator = new RandomDirectionGenerator();

        // when
        final Direction actual = directionGenerator.generate();

        // then
        Assertions.assertThat(actual.getMove())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(1);
    }
}
