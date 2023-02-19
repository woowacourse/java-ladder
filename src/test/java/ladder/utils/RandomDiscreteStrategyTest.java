package ladder.utils;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomDiscreteStrategyTest {
    @RepeatedTest(10)
    @DisplayName("연속으로 이어지지 않는 라인을 생성한다.")
    void line_generateNotContinuous() {
        // given
        RandomDiscreteStrategy randomDiscreteStrategy = new RandomDiscreteStrategy();

        // when
        List<Boolean> randomLine = randomDiscreteStrategy.generate(5);

        // expected
        boolean isNotContinuous = IntStream.range(0, randomLine.size() - 1)
                .allMatch(i -> (randomLine.get(i) && randomLine.get(i + 1)) == false);
        assertThat(isNotContinuous).isTrue();
    }
}
