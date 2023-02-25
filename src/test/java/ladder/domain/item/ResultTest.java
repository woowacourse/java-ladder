package ladder.domain.item;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class ResultTest {

    @Test
    void getNames_메서드로_결과의_이름들을_알_수_있음() {
        Result result = new Result(List.of("꽝", "5000", "꽝", "3000"), 4);
        assertThat(result.getNames()).containsExactly("꽝", "5000", "꽝", "3000");
    }

    @Test
    void 플레이어_수와_결과의_수가_다르면_예외() {
        assertThatThrownBy(() -> new Result(List.of("꽝", "5000", "꽝", "3000"), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 수와 결과의 수가 다릅니다. 플레이어 : 3, 결과 : 4");
    }
}
