package domain.ladder;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        List<Bridge> nonContinuousBridge = List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.EMPTY, Bridge.BUILT);
        assertThatNoException()
                .isThrownBy(() -> new Line(nonContinuousBridge));
    }

    @DisplayName("연속되는 브릿지가 존재하면 예외가 발생한다.")
    @Test
    void constructFailWithContinuousBridge() {
        assertThatThrownBy(() -> new Line(List.of(Bridge.BUILT, Bridge.BUILT)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
