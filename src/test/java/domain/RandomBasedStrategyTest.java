package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBasedStrategyTest {

    @DisplayName("왼쪽 Point가 true라면 false를 반환한다.")
    @RepeatedTest(5)
    void generatePoint() {
        RandomBasedStrategy randomBasedStrategy = new RandomBasedStrategy();
        assertThat(randomBasedStrategy.generate(Point.EXIST))
                .isEqualTo(Point.NOT_EXIST);
    }

}