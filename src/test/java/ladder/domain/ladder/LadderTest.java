package ladder.domain.ladder;

import static ladder.domain.ladder.Ladder.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
                .hasMessage("최소 가로는 2, 세로는 1이어야 합니다. 현재 가로 : 3, 세로 : 0");
    }

    @Test
    void 생성시_플레이어의_수가_1이하이면_예외() {
        assertThatThrownBy(() -> of(1, 1, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 가로는 2, 세로는 1이어야 합니다. 현재 가로 : 1, 세로 : 1");
    }

    @Test
    void 생성시_플레이어의_수가_2이상이면_예외가_발생하지_않음() {
        assertDoesNotThrow(() -> of(2, 1, () -> true));
    }

    @Test
    void getRows_메서드로_연결된_정보를_알_수_있음() {
        Ladder ladder = of(3, 2, () -> true);
        assertThat(ladder.getRows()).containsExactly(
                List.of(true, false, false),
                List.of(true, false, false)
        );
    }
}
