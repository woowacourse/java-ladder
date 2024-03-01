package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLadderMakeStrategyTest {

    @Test
    @DisplayName("|-----|----- 인 Point로 Line이 생성되지 않는지 확인")
    void makeLine() {
        RandomLadderMakeStrategy randomLadderMakeStrategy = new RandomLadderMakeStrategy(5);
        Boolean[] booleans = randomLadderMakeStrategy.makeLine();
        Assertions.assertThat(booleans.length)
                .isEqualTo(5);
        Assertions.assertThat(booleans[booleans.length - 1])
                .isFalse();
    }
}
