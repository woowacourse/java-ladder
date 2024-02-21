package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("생성 테스트")
    @Test
    void createLine() {
        Assertions.assertThatCode(() -> new Line(filledStickGenerator(), 3))
                .doesNotThrowAnyException();
    }

    @DisplayName("라인은 인원 수 만큼의 막대를 갖는다.")
    @Test
    void lineHasStick() {
        int playerSize = 3;
        Line line = new Line(filledStickGenerator(), playerSize);

        List<Stick> sticks = line.getSticks();

        Assertions.assertThat(sticks).hasSize(playerSize);
    }

    private StickGenerator filledStickGenerator() {
        return () -> Stick.FILLED;
    }
}
