package laddergame.model.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("참여자의 개수와 생성되는 포인터의 개수가 같다.")
    void Should_Success_When_MakeLine() {
        int personCount = 4;
        assertThat(new Line(personCount).getLength()).isEqualTo(personCount);
    }

    @Test
    @DisplayName("리스트에 연속적으로 true가 포함될 경우 예외 발생")
    void Should_ThrowException_When_ContinueTrue() {
        assertThatThrownBy(() -> new Line(List.of(new Point(new Direction(false), new Direction(true)),
                new Point(new Direction(true), new Direction(true)),
                new Point(new Direction(true), new Direction(false)))));
    }
}
