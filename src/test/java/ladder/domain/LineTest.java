package ladder.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {

    @Test
    void 라인은_주어진_사람보다_하나_적은_좌표값을_가진다() {
        Line line = new Line(5);

        assertThat(line.toUnmodifiableBars())
                .hasSize(4);
    }

    @Test
    void 주어진_사람이_한명_이하면_예외() {
        assertThatThrownBy(() -> {
            new Line(1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 2명 이상이어야 합니다.");
    }
}
