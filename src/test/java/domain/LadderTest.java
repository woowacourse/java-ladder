package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("두 지점 사이에 연결이 없는 사다리가 생성되지 않는지 검증")
    void validLadder() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Ladder(
                        List.of(new Line(false, true, false), new Line(true, false, false),
                                new Line(false, true, false), new Line(false, true, false),
                                new Line(false, true, false), new Line(false, true, false))));
    }

    @Test
    @DisplayName("두 지점 사이에 연결이 없는 사다리가 생성되지 않는지 검증")
    void noConnectedLadder() {
        Assertions.assertThatThrownBy(() -> new Ladder(
                        List.of(new Line(false, true, false), new Line(false, true, false), new Line(false, true, false),
                                new Line(false, true, false), new Line(false, true, false), new Line(false, true, false))))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("두 지점 사이에는 반드시 한개 이상의 발판이 있어야 합니다.");
    }
}
