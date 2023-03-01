package ladder.domain;

import static ladder.domain.Position.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositionTest {

    @Test
    void index가_0보다_작으면_예외() {
        assertThatThrownBy(() -> valueOf(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("index 는 0 이상이어야 합니다.");
    }

    @Test
    void index가_0보다_크면_여러번_호출해도_동일한_객체_반환() {
        assertThat(valueOf(1))
                .isEqualTo(valueOf(1));
    }

    @Test
    void moveRight_메서드를_호출했을_경우에_1만큼_이동한_포지션이_반환됨() {
        assertThat(valueOf(0).moveRight())
                .isEqualTo(valueOf(1));
    }

    @Test
    void moveLeft_메서드를_호출했을_경우에_1만큼_이동한_포지션이_반환됨() {
        assertThat(valueOf(1).moveLeft())
                .isEqualTo(valueOf(0));
    }
}
