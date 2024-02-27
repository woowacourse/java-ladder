package laddergame.domain;

import laddergame.domain.result.Trace;
import laddergame.domain.target.Targets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TargetsTest {

    @DisplayName("실행 결과를 입력받아 Targets 객체를 생성한다.")
    @Test
    void testCreateTargets() {
        // given
        List<String> input = List.of("꽝","5000","꽝","3000");

        // when & then
        Assertions.assertThatCode(() -> new Targets(input, 4))
                .doesNotThrowAnyException();
    }

    @DisplayName("실행 결과와 참여자 수가 같지 않으면 예외를 발생시킨다.")
    @Test
    void testValidateNumber() {
        // given
        List<String> input = List.of("꽝");

        // when & then
        Assertions.assertThatThrownBy(() -> new Targets(input, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 실행 결과와 참여자 수가 같지 않습니다.");
    }

    @DisplayName("Trace를 Target으로 변환한다.")
    @Test
    void testConvertToTraceBy() {
        // given
        Trace leftTrace = new Trace(0);
        Trace rightTrace = new Trace(3);
        Targets targets = new Targets(List.of("꽝","5000","꽝","3000"), 4);

        // when
        laddergame.domain.target.Target leftTarget = targets.convertToTarget(leftTrace);
        laddergame.domain.target.Target rightTarget = targets.convertToTarget(rightTrace);

        // then
        Assertions.assertThat(leftTarget).isEqualTo(new laddergame.domain.target.Target("꽝"));
        Assertions.assertThat(rightTarget).isEqualTo(new laddergame.domain.target.Target("3000"));
    }
}
