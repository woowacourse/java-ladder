package ladder.domain;

import static ladder.domain.Ladder.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class LadderTest {

    @Test
    void 생성시_라인의_수가_0이하이면_예외() {
        assertThatThrownBy(() -> of(3, 0, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 세로는 1보다 커야 합니다 합니다. 현재 세로 : 0");
    }

    @Test
    void 생성시_플레이어의_수가_1이하이면_예외() {
        assertThatThrownBy(() -> of(1, 1, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("길이는 2 이상이어야 합니다. 현재 : 1");
    }

    @Test
    void 생성시_플레이어의_수가_2이상이면_예외가_발생하지_않음() {
        assertThatCode(() -> of(2, 1, () -> true))
                .doesNotThrowAnyException();
    }

    @Test
    void getRows_메서드로_연결된_정보를_알_수_있음() {
        Ladder ladder = of(3, 2, () -> true);
        assertThat(ladder.getRows())
                .containsExactly(
                        List.of(true, false, false),
                        List.of(true, false, false)
                );
    }

    @Test
    void ladder에서_시작_포지션을_받게_되면_결과_포지션을_반환() {
        Ladder ladder = of(3, 2, () -> true);
        assertThat(ladder.calculateResult(Position.valueOf(0)))
                .isEqualTo(Position.valueOf(0));
        assertThat(ladder.calculateResult(Position.valueOf(1)))
                .isEqualTo(Position.valueOf(1));
        assertThat(ladder.calculateResult(Position.valueOf(2)))
                .isEqualTo(Position.valueOf(2));
    }
}
