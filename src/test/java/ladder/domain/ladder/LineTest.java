package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 라인_너비_초기화_일치_확인() {
        int length = 5;
        assertThat(new Line(length, new ForcedTrueRule()).getPoints().size()).isEqualTo(5);
    }

    @Test
    public void 강제_True_다음_포인트_인덱스_얻기() {
        Line line = new Line(5, new ForcedTrueRule());
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    public void 강제_False_다음_포인트_인덱스_얻기() {
        Line line = new Line(5, new ForcedFalseRule());
        assertThat(line.move(0)).isEqualTo(0);
    }
}

class ForcedTrueRule implements LadderRule {
    @Override
    public boolean isAvailablePoint() {
        return true;
    }
}

class ForcedFalseRule implements LadderRule {
    @Override
    public boolean isAvailablePoint() {
        return false;
    }
}