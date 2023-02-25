package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 길이가_2이상이면_예외가_발생하지_않음() {
        Row.valueOf(2, new MockConnectionJudgement(true));
    }

    @Test
    void 포인트가_오른쪽으로_연결되었는지_확인() {
        Row row = Row.valueOf(3, new MockConnectionJudgement(true));
        assertThat(row.getPoints())
                .containsExactly(true, false, false);
    }
}
