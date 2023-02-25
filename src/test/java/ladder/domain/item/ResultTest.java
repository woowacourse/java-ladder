package ladder.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class ResultTest {

    @Test
    void getNames_메서드로_결과의_이름들을_알_수_있음() {
        Result result = new Result(List.of("꽝", "5000", "꽝", "3000"));
        assertThat(result.getNames()).containsExactly("꽝", "5000", "꽝", "3000");
    }
}
