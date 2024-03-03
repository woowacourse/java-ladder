package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLineGenerateStrategyTest {

    @Test
    @DisplayName("|-----|----- 인 Point로 Line이 생성되지 않는지 확인")
    void makeLine() {
        LineGenerateStrategy randomLineMakeStrategy = new RandomLineGenerateStrategy();
        List<Boolean> generate = randomLineMakeStrategy.generate(5);
        Assertions.assertThat(generate.size())
                .isEqualTo(5);
        Assertions.assertThat(generate.get(generate.size() - 1))
                .isFalse();
    }
}
