package laddergame.domain;

import laddergame.domain.result.Trace;
import laddergame.domain.target.Targets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TargetsTest {

    @DisplayName("Trace를 Target으로 변환한다.")
    @Test
    void testConvertToTraceBy() {
        // given
        Trace leftTrace = new Trace(0);
        Trace rightTrace = new Trace(3);
        Targets targets = new Targets(List.of("꽝","5000","꽝","3000"));

        // when
        laddergame.domain.target.Target leftTarget = targets.convertToTarget(leftTrace);
        laddergame.domain.target.Target rightTarget = targets.convertToTarget(rightTrace);

        // then
        Assertions.assertThat(leftTarget).isEqualTo(new laddergame.domain.target.Target("꽝"));
        Assertions.assertThat(rightTarget).isEqualTo(new laddergame.domain.target.Target("3000"));
    }
}
