package laddergame.domain;

import laddergame.domain.move.LeftStrategy;
import laddergame.domain.move.RightStrategy;
import laddergame.domain.move.Trace;
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
        Trace leftTrace = new Trace(0, new LeftStrategy());
        Trace rightTrace = new Trace(2, new RightStrategy());
        Targets targets = new Targets(List.of("꽝","5000","꽝","3000"));

        // when
        laddergame.domain.target.Target leftTarget = targets.convertToTraceBy(leftTrace);
        laddergame.domain.target.Target rightTarget = targets.convertToTraceBy(rightTrace);

        // then
        Assertions.assertThat(leftTarget).isEqualTo(new laddergame.domain.target.Target("꽝"));
        Assertions.assertThat(rightTarget).isEqualTo(new laddergame.domain.target.Target("3000"));
    }
}
