package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters"})
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
        assertThatCode(() -> Row.valueOf(2, new MockConnectionJudgement(true)))
                .doesNotThrowAnyException();
    }

    @Test
    void 포인트가_오른쪽으로_연결되었는지_확인() {
        Row row = Row.valueOf(3, new MockConnectionJudgement(true));
        assertThat(row.getPoints())
                .containsExactly(true, false, false);
    }

    @Test
    void 오른쪽으로_연결되어_있는_경우에_다음_포인트를_구함() {
        Row row = Row.valueOf(3, new MockConnectionJudgement(true));
        assertThat(row.calculateNextPosition(Position.valueOf(0)))
                .isEqualTo(Position.valueOf(1));
    }

    @Test
    void 왼쪽으로_연결되어_있는_경우에_다음_포인트를_구함() {
        Row row = Row.valueOf(3, new MockConnectionJudgement(true));
        assertThat(row.calculateNextPosition(Position.valueOf(1)))
                .isEqualTo(Position.valueOf(0));
    }

    @Test
    void 연결되어_있지_않은_경우에_다음_포인트를_구함() {
        Row row = Row.valueOf(3, new MockConnectionJudgement(false));
        assertThat(row.calculateNextPosition(Position.valueOf(2)))
                .isEqualTo(Position.valueOf(2));
    }

    @Test
    void 생성시_최대한_연결된_경우를_생성() {
        Row row = Row.valueOf(5, new MockConnectionJudgement(true));
        assertThat(row.getPoints())
                .containsExactly(true, false, true, false, false);
    }

    @Test
    void 생성시_최대한_연결되지_않은_경우를_생성() {
        Row row = Row.valueOf(3, new MockConnectionJudgement(false));
        assertThat(row.getPoints())
                .containsExactly(false, false, false);
    }
}
