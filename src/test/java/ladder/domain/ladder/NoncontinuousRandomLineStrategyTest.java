package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NoncontinuousRandomLineStrategyTest {
    @Test
    @DisplayName("연속으로 이어지지 않는 라인을 생성한다.")
    void line_generateNotContinuous() {
        // given
        NoncontinuousRandomLineStrategy nonContinuousRandomLineStrategy = new NoncontinuousRandomLineStrategy();

        // when
        List<Step> randomLine = nonContinuousRandomLineStrategy.generate(5);
        boolean isSame = false;
        for (int i = 0; i < randomLine.size() - 1; i++) {
            if ((randomLine.get(i).equals(randomLine.get(i + 1))) && randomLine.get(i).equals(Step.EXIST)) {
                isSame = true;
                break;
            }
        }

        // expected
        assertThat(isSame).isFalse();
    }
}
