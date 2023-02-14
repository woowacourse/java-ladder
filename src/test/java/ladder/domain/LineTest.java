package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 라인은_주어진_사람보다_하나_적은_좌표값을_가진다() {
        Line line = new Line(5);

        assertThat(line.toUnmodifiablePoints())
                .hasSize(4);
    }

    @Test
    void 주어진_사람이_한명_이하면_예외() {
        assertThatThrownBy(() -> {
            new Line(1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 1명이하일 수 없습니다.");
    }
}
