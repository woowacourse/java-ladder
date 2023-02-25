package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class RowTest {

    @Test
    void 길이가_2보다_작으면_예외() {
        assertThatThrownBy(() -> Row.valueOf(1, new MockConnectionJudgement(true)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("길이는 2 이상이어야 합니다. 현재 : 1");
    }
}
