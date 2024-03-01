package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLineMakeStrategyTest {

    @Test
    @DisplayName("|-----|----- 인 Point로 Line이 생성되지 않는지 확인")
    void makeLine() {
        RandomLineMakeStrategy randomLineMakeStrategy = new RandomLineMakeStrategy(5);
        Boolean[] booleans = randomLineMakeStrategy.makeLine();
        Assertions.assertThat(booleans.length)
                .isEqualTo(5);
        Assertions.assertThat(booleans[booleans.length - 1])
                .isFalse();
    }
}
