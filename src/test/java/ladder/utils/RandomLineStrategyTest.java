package ladder.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineStrategyTest {
    @Test
    @DisplayName("연속으로 이어지지 않는 라인을 생성한다.")
    void line_generateNotContinuous() {
        // given
        RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

        // when
        List<Boolean> randomLine = randomLineStrategy.generate(5);
        boolean isSame = false;
        for (int i = 0; i < randomLine.size() - 1; i++) {
            if ((randomLine.get(i).equals(randomLine.get(i + 1))) && randomLine.get(i)) {
                isSame = true;
                break;
            }
        }

        // expected
        assertThat(isSame).isFalse();
    }
}
