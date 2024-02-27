package domain;

import domain.ladder.Line;
import domain.ladder.Stick;
import domain.ladder.StickGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("라인은 인원 수 -1 만큼의 막대를 갖는다.")
    @Test
    void lineHasStick() {
        int playerSize = 3;
        Line line = new Line(filledStickGenerator(), playerSize);

        List<Stick> sticks = line.getSticks();

        assertThat(sticks).hasSize(playerSize - 1);
    }

    @DisplayName("라인에 연속된 막대는 있을 수 없다.")
    @Test
    void opposite() {
        int playerSize = 3;
        Line line = new Line(filledStickGenerator(), playerSize);

        List<Stick> sticks = line.getSticks();

        assertThat(sticks.get(playerSize - 2)).isEqualTo(Stick.NOT_FILLED);
    }

    private StickGenerator filledStickGenerator() {
        return () -> Stick.FILLED;
    }
}
